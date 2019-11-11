package br.com.trabalho.ia.ui.familia;


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

public class TempoEstudo extends Fragment {

    public TempoEstudo() {
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
        View view = inflater.inflate(R.layout.fragment_tempo_estudo, container, false);
        Button button = view.findViewById(R.id.button_proximo_tempo_estudo);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_tempo_estudo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_tempo_estudo_concordo:
                        App.getAluno().setTempoEstudo(100);
                        break;
                    case R.id.radio_tempo_estudo_concordop :
                        App.getAluno().setTempoEstudo(75);
                        break;
                    case R.id.radio_tempo_estudo_neutro:
                        App.getAluno().setTempoEstudo(50);
                        break;
                    case R.id.radio_tempo_estudo_discordop :
                        App.getAluno().setTempoEstudo(25);
                        break;
                    case R.id.radio_tempo_estudo_discordo :
                        App.getAluno().setTempoEstudo(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_familia, new MateriaDidatico())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
