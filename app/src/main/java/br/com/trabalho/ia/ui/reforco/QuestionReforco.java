package br.com.trabalho.ia.ui.reforco;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.trabalho.ia.R;

public class QuestionReforco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_reforco);
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_reforco, new AprenderMais())
                .commit ();
    }
}
