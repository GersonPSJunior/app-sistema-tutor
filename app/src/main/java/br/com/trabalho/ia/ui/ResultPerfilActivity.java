package br.com.trabalho.ia.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_perfil);

        loadUi();
        loadText();
        App.getAluno().setAlunoRepository(new AlunoRepository(this));
        App.getAluno().insert();
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
    }
}
