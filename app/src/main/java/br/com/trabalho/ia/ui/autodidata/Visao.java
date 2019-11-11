package br.com.trabalho.ia.ui.autodidata;

import android.content.Intent;
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
import br.com.trabalho.ia.ui.familia.QuestionFamilia;

public class Visao extends Fragment {

    public Visao() {
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
        View view = inflater.inflate(R.layout.fragment_visao, container, false);
        Button button = view.findViewById(R.id.button_proximo_visao);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_visao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_visao_concordo:
                        App.getAluno().setVisao(100);
                        break;
                    case R.id.radio_visao_concordop :
                        App.getAluno().setVisao(75);
                        break;
                    case R.id.radio_visao_neutro:
                        App.getAluno().setVisao(50);
                        break;
                    case R.id.radio_visao_discordop :
                        App.getAluno().setVisao(25);
                        break;
                    case R.id.radio_visao_discordo :
                        App.getAluno().setVisao(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                App.getAluno().setMediaAutodidata((double) ((App.getAluno().getAudicao() +
                        App.getAluno().getRepeticao() + App.getAluno().getVisao()) / 3));
                Intent intent = new Intent(getActivity(), QuestionFamilia.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
