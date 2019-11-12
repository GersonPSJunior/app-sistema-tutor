package br.com.trabalho.ia.ui.extra;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.ui.reforco.QuestionReforco;

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
        final View view = inflater.inflate(R.layout.fragment_extra_curricular, container, false);
        Button button = view.findViewById(R.id.button_proximo_extra_curricular);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_extra_curricular);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_extra_curricular_sim:
                        getActivity().getSupportFragmentManager ()
                                .beginTransaction ()
                                .replace (R.id.frame_extra, new Ajuda())
                                .addToBackStack(null)
                                .commit ();
                        break;
                    case R.id.radio_extra_curricular_nao :
                        getActivity().startActivity(new Intent(getActivity(), QuestionReforco.class));
                        getActivity().finish();
                        break;
                    default:
                        Toast.makeText(getActivity(), "Selecione um opção", Toast.LENGTH_SHORT).show();
                        return;
                }

            }
        });
        return view;
    }

}
