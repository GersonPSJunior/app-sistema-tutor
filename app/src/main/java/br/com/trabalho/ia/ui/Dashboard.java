package br.com.trabalho.ia.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.ui.autodidata.QuestionAutodidata;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Button buttonInsert = findViewById(R.id.button_insert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, QuestionAutodidata.class);
                startActivity(intent);
            }
        });
    }
}
