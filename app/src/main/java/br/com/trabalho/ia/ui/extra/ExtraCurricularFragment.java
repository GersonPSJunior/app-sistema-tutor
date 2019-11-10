package br.com.trabalho.ia.ui.extra;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.trabalho.ia.R;

public class ExtraCurricularFragment extends Fragment {

    public ExtraCurricularFragment() {
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
        View view = inflater.inflate(R.layout.fragment_extra_curricular, container, false);
        Button button = view.findViewById(R.id.button_proximo_extra_curricular);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_extra, new Ajuda())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
