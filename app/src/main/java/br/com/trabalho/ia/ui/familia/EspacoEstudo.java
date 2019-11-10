package br.com.trabalho.ia.ui.familia;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.trabalho.ia.R;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionExtraCurricular.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
