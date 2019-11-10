package br.com.trabalho.ia.ui.extra;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import br.com.trabalho.ia.R;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), QuestionReforco.class));
                getActivity().finish();
            }
        });
        return view;
    }

}
