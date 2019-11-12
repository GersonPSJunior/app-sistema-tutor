package br.com.trabalho.ia.ui.extra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.trabalho.ia.R;

public class QuestionExtraCurricular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_extra_curricular);
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_extra, new ExtraCurricularFragment())
                .commit ();
    }
}
