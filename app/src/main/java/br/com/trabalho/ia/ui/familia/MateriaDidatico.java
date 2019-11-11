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

public class MateriaDidatico extends Fragment {

    public MateriaDidatico() {
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
        View view = inflater.inflate(R.layout.fragment_materia_didatico, container, false);
        Button button = view.findViewById(R.id.button_proximo_materia);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_materia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_materia_concordo:
                        App.getAluno().setMaterialDidatico(100);
                        break;
                    case R.id.radio_materia_concordop :
                        App.getAluno().setMaterialDidatico(75);
                        break;
                    case R.id.radio_materia_neutro:
                        App.getAluno().setMaterialDidatico(50);
                        break;
                    case R.id.radio_materia_discordop :
                        App.getAluno().setMaterialDidatico(25);
                        break;
                    case R.id.radio_materia_discordo :
                        App.getAluno().setMaterialDidatico(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_familia, new EspacoEstudo())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
