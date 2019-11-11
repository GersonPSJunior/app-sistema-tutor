package br.com.trabalho.ia.ui.extra;


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
import br.com.trabalho.ia.ui.reforco.QuestionReforco;

public class AuxilioEscolar extends Fragment {

    public AuxilioEscolar() {
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
        View view = inflater.inflate(R.layout.fragment_auxilio_escolar, container, false);
        Button button = view.findViewById(R.id.button_proximo_auxilio_escolar);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_auxilio_escolar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_auxilio_escolar_concordo:
                        App.getAluno().setAuxilioEscolar(100);
                        break;
                    case R.id.radio_auxilio_escolar_concordop :
                        App.getAluno().setAuxilioEscolar(75);
                        break;
                    case R.id.radio_auxilio_escolar_neutro:
                        App.getAluno().setAuxilioEscolar(50);
                        break;
                    case R.id.radio_auxilio_escolar_discordop :
                        App.getAluno().setAuxilioEscolar(25);
                        break;
                    case R.id.radio_auxilio_escolar_discordo :
                        App.getAluno().setAuxilioEscolar(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                App.getAluno().setMediaExtraCurricular((double) ((App.getAluno().getAjuda() +
                                        App.getAluno().getConsumoTempo() + App.getAluno().getAuxilioEscolar())/3));
                getActivity().startActivity(new Intent(getActivity(), QuestionReforco.class));
                getActivity().finish();
            }
        });
        return view;
    }

}
