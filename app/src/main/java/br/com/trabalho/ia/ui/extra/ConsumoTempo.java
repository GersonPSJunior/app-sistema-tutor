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

public class ConsumoTempo extends Fragment {

    public ConsumoTempo() {
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
        View view = inflater.inflate(R.layout.fragment_consumo_tempo, container, false);
        Button button = view.findViewById(R.id.button_proximo_consumo_tempo);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_consumo_tempo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_consumo_tempo_concordo:
                        App.getAluno().setConsumoTempo(100);
                        break;
                    case R.id.radio_consumo_tempo_concordop :
                        App.getAluno().setConsumoTempo(75);
                        break;
                    case R.id.radio_consumo_tempo_neutro:
                        App.getAluno().setConsumoTempo(50);
                        break;
                    case R.id.radio_consumo_tempo_discordop :
                        App.getAluno().setConsumoTempo(25);
                        break;
                    case R.id.radio_consumo_tempo_discordo :
                        App.getAluno().setConsumoTempo(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_extra, new AuxilioEscolar())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
