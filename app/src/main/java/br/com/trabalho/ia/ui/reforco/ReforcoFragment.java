package br.com.trabalho.ia.ui.reforco;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.ui.ResultPerfilActivity;

public class ReforcoFragment extends Fragment {

    public ReforcoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_reforco, container, false);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_reforco);
        Button button = view.findViewById(R.id.button_proximo_reforco);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_reforco_sim:
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_reforco, new AprenderMais())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.radio_reforco_nao:
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Questionario")
                                .setMessage("Tem certeza que deseja finalizar o questionario?")
                                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        getActivity().startActivity(new Intent(getActivity(), ResultPerfilActivity.class));
                                        getActivity().finish();
                                    }
                                })
                                .setNegativeButton("não", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
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
