package br.com.trabalho.ia.ui.familia;


import android.content.Intent;
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
import br.com.trabalho.ia.ui.extra.QuestionExtraCurricular;

public class EspacoEstudo extends Fragment {

    public EspacoEstudo() {
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
        View view = inflater.inflate(R.layout.fragment_espaco_estudo, container, false);
        Button button = view.findViewById(R.id.button_proximo_espaco_estudo);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_espaco_estudo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_espaco_estudo_concordo:
                        App.getAluno().setEspacoEstudo(100);
                        break;
                    case R.id.radio_espaco_estudo_concordop :
                        App.getAluno().setEspacoEstudo(75);
                        break;
                    case R.id.radio_espaco_estudo_neutro:
                        App.getAluno().setEspacoEstudo(50);
                        break;
                    case R.id.radio_espaco_estudo_discordop :
                        App.getAluno().setEspacoEstudo(25);
                        break;
                    case R.id.radio_espaco_estudo_discordo :
                        App.getAluno().setEspacoEstudo(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                App.getAluno().setMediaFamilia((double) ((App.getAluno().getTempoEstudo() +
                        App.getAluno().getMaterialDidatico() + App.getAluno().getEspacoEstudo())/3));
                Intent intent = new Intent(getActivity(), QuestionExtraCurricular.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
