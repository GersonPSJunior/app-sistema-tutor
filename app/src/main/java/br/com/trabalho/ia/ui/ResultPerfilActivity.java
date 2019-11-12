package br.com.trabalho.ia.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
    private ConstraintLayout ConstraintExtra;
    private ConstraintLayout ConstraintReforco;
    private Double aproveitamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_perfil);

        loadUi();
        loadText();
        identifyVisible();
        App.getAluno().setAlunoRepository(new AlunoRepository(this));
        App.getAluno().insert();
    }

    private void identifyVisible() {
        if (App.getAluno().getAjuda() == null) ConstraintExtra.setVisibility(View.GONE);

        if (App.getAluno().getConcorso() == null) ConstraintReforco.setVisibility(View.GONE);

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
        aproveitamento = (double) (App.getAluno().getAudicao() + App.getAluno().getRepeticao()
                + App.getAluno().getVisao() + App.getAluno().getEspacoEstudo())/4;
        textResultAproveitamento.setText(aproveitamento +"%");
        textResultAproveitamento.setTextColor(aproveitamento < 60 ? Color.RED : Color.GREEN);
        feadbackValid();
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
        ConstraintExtra = findViewById(R.id.constraint_extra);
        ConstraintReforco = findViewById(R.id.constraint_reforco);
    }
}
