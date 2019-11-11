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

public class Concurso extends Fragment {

    public Concurso() {
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
        View view = inflater.inflate(R.layout.fragment_concurso, container, false);
        Button button = view.findViewById(R.id.button_proximo_concurso);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_concurso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_concurso_concordo:
                        App.getAluno().setConcorso(100);
                        break;
                    case R.id.radio_concurso_concordop :
                        App.getAluno().setConcorso(75);
                        break;
                    case R.id.radio_concurso_neutro:
                        App.getAluno().setConcorso(50);
                        break;
                    case R.id.radio_concurso_discordop :
                        App.getAluno().setConcorso(25);
                        break;
                    case R.id.radio_concurso_discordo :
                        App.getAluno().setConcorso(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_reforco, new MelhorarNota())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
