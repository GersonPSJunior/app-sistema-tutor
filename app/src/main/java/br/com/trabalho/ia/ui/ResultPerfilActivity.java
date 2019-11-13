package br.com.trabalho.ia.ui;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.config.App;
import br.com.trabalho.ia.repository.AlunoRepository;

public class ResultPerfilActivity extends AppCompatActivity {


    private TextView textAudicao;
    private TextView textRepeticao;
    private TextView textVisao;
    private TextView textMediaAprendizado;
    private TextView textFamiliaEspaco;
    private TextView textFamiliaMateria;
    private TextView textFamiliaMedia;
    private TextView textFamiliaTempo;
    private TextView textExtraAjuda;
    private TextView textExtraAuxilio;
    private TextView textExtraMedia;
    private TextView textExtraTempo;
    private TextView textReforcoAprendizado;
    private TextView textReforcoConcurso;
    private TextView textReforcoMedia;
    private TextView textReforcoNota;
    private TextView textResultAproveitamento;
    private TextView textResultFeadback;
    private ConstraintLayout constraintExtra;
    private ConstraintLayout constraintReforco;
    private ConstraintLayout constraintResultAproveitamento;
    private Double aproveitamento;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_perfil);

        loadUi();
        loadText();
        calculoAproveitamento();
        feadbackValid();
        App.getAluno().setAlunoRepository(new AlunoRepository(this));
        App.getAluno().insert();

    }

    @Override
    protected void onResume() {
        super.onResume();
        new buscaInfo().execute();
    }

    private void calculoAproveitamento() {
        if (App.getAluno().getAjuda() == null && App.getAluno().getConcorso() == null)
            aproveitamento = (App.getAluno().getMediaAutodidata() * 0.5 + App.getAluno().getMediaFamilia() * 0.5);

        if (App.getAluno().getAjuda() == null && App.getAluno().getConcorso() != null)
            aproveitamento = (App.getAluno().getMediaAutodidata() * 0.35 +
                    App.getAluno().getMediaFamilia() * 0.35 + App.getAluno().getMediaReforco() * 0.3);

        if (App.getAluno().getAjuda() != null && App.getAluno().getConcorso() == null)
            aproveitamento = (App.getAluno().getMediaAutodidata() * 0.35 +
                    App.getAluno().getMediaFamilia() * 0.35 + App.getAluno().getMediaExtraCurricular() * 0.3);

        if (App.getAluno().getAjuda() != null && App.getAluno().getConcorso() != null)
            aproveitamento = (App.getAluno().getMediaAutodidata() * 0.3 + App.getAluno().getMediaFamilia() * 0.3 +
                    App.getAluno().getMediaReforco() * 0.2 + App.getAluno().getMediaExtraCurricular() * 0.2);

        textResultAproveitamento.setText(aproveitamento +"%");
        textResultAproveitamento.setTextColor(aproveitamento < 60 ? Color.RED : Color.GREEN);
    }

    private void identifyVisible() {
        constraintExtra.setVisibility(App.getAluno().getAjuda() == null ? View.GONE : View.VISIBLE);

        constraintReforco.setVisibility(App.getAluno().getConcorso() == null ? View.GONE : View.VISIBLE);

    }

    private void loadText() {
        textAudicao.setText(App.getAluno().getAudicao() +"%");
        textRepeticao.setText(App.getAluno().getRepeticao() +"%");
        textVisao.setText(App.getAluno().getVisao() +"%");
        textMediaAprendizado.setText(App.getAluno().getMediaAutodidata() +"%");
        textFamiliaEspaco.setText(App.getAluno().getEspacoEstudo() +"%");
        textFamiliaMateria.setText(App.getAluno().getMaterialDidatico() +"%");
        textFamiliaMedia.setText(App.getAluno().getMediaFamilia() +"%");
        textFamiliaTempo.setText(App.getAluno().getTempoEstudo() +"%");
        textExtraAjuda.setText(App.getAluno().getAjuda() +"%");
        textExtraAuxilio.setText(App.getAluno().getAuxilioEscolar() +"%");
        textExtraMedia.setText(App.getAluno().getMediaExtraCurricular() +"%");
        textExtraTempo.setText(App.getAluno().getConsumoTempo() +"%");
        textReforcoAprendizado.setText(App.getAluno().getAprenderMais() +"%");
        textReforcoConcurso.setText(App.getAluno().getConcorso() +"%");
        textReforcoMedia.setText(App.getAluno().getMediaReforco() +"%");
        textReforcoNota.setText(App.getAluno().getMelhorarNota() +"%");
    }

    private void feadbackValid() {
        if (aproveitamento > 75){
            textResultFeadback.setText("Parabéns! Está muito bem encaminhado seus estudos. Logico que sempre dá para melhorar um pouco mais, mas continue como está!");
        } else if (aproveitamento <= 75 && aproveitamento > 50){
            textResultFeadback.setText("Tome cuidado com os detalhes. Você está indo bem, mas sempre procure melhorar, busque novos caminhos para estudar e se desenvolver mais!");
        } else  if (aproveitamento <= 50 && aproveitamento > 25){
            textResultFeadback.setText("Sempre há algo que se pode melhorar. Busque novas alternativas, o caminho que está seguindo pode não ser o melhor.");
        } else if (aproveitamento <= 25){
            textResultFeadback.setText("Definitivamente o que está fazendo não está te ajudando, busque novas formas de estudar e coisas que possam te ajudar a se desenvolver melhor.");
        }
    }

    private void loadUi() {
        textAudicao = findViewById(R.id.text_audicao);
        textRepeticao = findViewById(R.id.text_repeticao);
        textVisao = findViewById(R.id.text_visao);
        textMediaAprendizado = findViewById(R.id.text_media_aprendizado);
        textFamiliaEspaco = findViewById(R.id.text_familia_espaco);
        textFamiliaMateria = findViewById(R.id.text_familia_materia);
        textFamiliaMedia = findViewById(R.id.text_familia_media);
        textFamiliaTempo = findViewById(R.id.text_familia_tempo);
        textExtraAjuda = findViewById(R.id.text_extra_ajuda);
        textExtraAuxilio = findViewById(R.id.text_extra_auxilio);
        textExtraMedia = findViewById(R.id.text_extra_media);
        textExtraTempo = findViewById(R.id.text_extra_tempo);
        textReforcoAprendizado = findViewById(R.id.text_reforco_aprendizado);
        textReforcoConcurso = findViewById(R.id.text_reforco_concurso);
        textReforcoMedia = findViewById(R.id.text_reforco_media);
        textReforcoNota = findViewById(R.id.text_reforco_nota);
        textResultAproveitamento = findViewById(R.id.text_result_aproveitamento);
        textResultFeadback = findViewById(R.id.text_result_feadback);
        constraintExtra = findViewById(R.id.constraint_extra);
        constraintReforco = findViewById(R.id.constraint_reforco);
        constraintResultAproveitamento = findViewById(R.id.constraint_result_aproveitamento);
        progressBar = findViewById(R.id.progress_result);
    }

    class buscaInfo extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            constraintResultAproveitamento.setVisibility(View.GONE);
            constraintExtra.setVisibility(View.GONE);
            constraintReforco.setVisibility(View.GONE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String time = 3 + (int) (Math.random() * 6) + "000";
                Thread.sleep(Long.valueOf(time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void voids) {
            progressBar.setVisibility(View.GONE);
            constraintResultAproveitamento.setVisibility(View.VISIBLE);
            identifyVisible();
        }
    }
}
