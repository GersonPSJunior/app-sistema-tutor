package br.com.trabalho.ia.ui.autodidata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.trabalho.ia.R;

public class QuestionAutodidata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_autodidata);
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_aprendizado, new AutodidataFragment())
                .commit ();
    }
}
