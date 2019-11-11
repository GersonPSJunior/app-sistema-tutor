package br.com.trabalho.ia.ui.familia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.trabalho.ia.R;

public class QuestionFamilia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_familia);
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_familia, new TempoEstudo())
                .commit ();
    }
}
