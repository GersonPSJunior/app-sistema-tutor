package br.com.trabalho.ia.ui.autodidata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.config.App;

public class Audicao extends Fragment {

    public Audicao() {
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
        View view = inflater.inflate(R.layout.fragment_audicao, container, false);
        Button button = view.findViewById(R.id.button_proximo_audicao);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_audicao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_audicao_concordo :
                        App.getAluno().setAudicao(100);
                        break;
                    case R.id.radio_audicao_concordop :
                        App.getAluno().setAudicao(75);
                        break;
                    case R.id.radio_audicao_neutro:
                        App.getAluno().setAudicao(50);
                        break;
                    case R.id.radio_audicao_discordop :
                        App.getAluno().setAudicao(25);
                        break;
                    case R.id.radio_audicao_discordo :
                        App.getAluno().setAudicao(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_aprendizado, new Repeticao())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }
}
