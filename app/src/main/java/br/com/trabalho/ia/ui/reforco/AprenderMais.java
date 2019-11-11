package br.com.trabalho.ia.ui.reforco;


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

public class AprenderMais extends Fragment {

    public AprenderMais() {
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
        View view = inflater.inflate(R.layout.fragment_aprender_mais, container, false);
        Button button = view.findViewById(R.id.button_proximo_aprender_mais);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_aprender_mais);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_aprender_mais_concordo:
                        App.getAluno().setAprenderMais(100);
                        break;
                    case R.id.radio_aprender_mais_concordop :
                        App.getAluno().setAprenderMais(75);
                        break;
                    case R.id.radio_aprender_mais_neutro:
                        App.getAluno().setAprenderMais(50);
                        break;
                    case R.id.radio_aprender_mais_discordop :
                        App.getAluno().setAprenderMais(25);
                        break;
                    case R.id.radio_aprender_mais_discordo :
                        App.getAluno().setAprenderMais(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_reforco, new Concurso())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
