package br.com.trabalho.ia.ui.autodidata;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import br.com.trabalho.ia.R;

public class AutodidataFragment extends Fragment {

    public AutodidataFragment() {
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
        View view = inflater.inflate(R.layout.fragment_autodidata, container, false);
        Button button = view.findViewById(R.id.button_proximo_autodidata);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.frame_aprendizado, new Audicao())
                        .addToBackStack(null)
                        .commit ();
            }
        });
        return view;
    }

}
