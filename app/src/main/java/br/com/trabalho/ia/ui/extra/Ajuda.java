package br.com.trabalho.ia.ui.extra;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.config.App;

public class Ajuda extends Fragment {

    public Ajuda() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ajuda, container, false);
        Button button = view.findViewById(R.id.button_proximo_ajuda);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_ajuda);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_ajuda_concordo:
                        App.getAluno().setAjuda(100);
                        break;
                    case R.id.radio_ajuda_concordop :
                        App.getAluno().setAjuda(75);
                        break;
                    case R.id.radio_ajuda_neutro:
                        App.getAluno().setAjuda(50);
                        break;
                    case R.id.radio_ajuda_discordop :
                        App.getAluno().setAjuda(25);
                        break;
                    case R.id.radio_ajuda_discordo :
                        App.getAluno().setAjuda(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_extra, new ConsumoTempo())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
