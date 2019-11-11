package br.com.trabalho.ia.ui.reforco;

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
import br.com.trabalho.ia.ui.ResultPerfilActivity;

public class MelhorarNota extends Fragment {

    public MelhorarNota() {
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
        View view = inflater.inflate(R.layout.fragment_melhorar_nota, container, false);
        Button button = view.findViewById(R.id.button_proximo_melhorar_nota);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_melhorar_nota);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_melhorar_nota_concordo:
                        App.getAluno().setMelhorarNota(100);
                        break;
                    case R.id.radio_melhorar_nota_concordop :
                        App.getAluno().setMelhorarNota(75);
                        break;
                    case R.id.radio_melhorar_nota_neutro:
                        App.getAluno().setMelhorarNota(50);
                        break;
                    case R.id.radio_melhorar_nota_discordop :
                        App.getAluno().setMelhorarNota(25);
                        break;
                    case R.id.radio_melhorar_nota_discordo :
                        App.getAluno().setMelhorarNota(0);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }
                App.getAluno().setMediaReforco((double) ((App.getAluno().getAprenderMais() +
                        App.getAluno().getConcorso() + App.getAluno().getMelhorarNota())/3));
                getActivity().startActivity(new Intent(getActivity(), ResultPerfilActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }
}
