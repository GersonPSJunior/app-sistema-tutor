package br.com.trabalho.ia.ui;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.config.App;
import br.com.trabalho.ia.domain.Aluno;
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
    private ProgressBar progressBar;
    private List<Aluno> alunos;
    private List<Aluno> alunos25;
    private List<Aluno> alunos50;
    private List<Aluno> alunos75;
    private List<Aluno> alunos100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_perfil);

        loadUi();
        loadText();
        alunos = new AlunoRepository(this).listAll();
//        if (alunos != null)
//            for (Aluno aluno : alunos) {
//                if (calcularAproveitamento(aluno) <= 25)
//                    alunos25.add(aluno);
//
//                if (calcularAproveitamento(aluno) > 25 && calcularAproveitamento(aluno) <= 50)
//                    alunos50.add(aluno);
//
//                if (calcularAproveitamento(aluno) > 50 && calcularAproveitamento(aluno) <= 75)
//                    alunos75.add(aluno);
//
//                if (calcularAproveitamento(aluno) > 75)
//                    alunos100.add(aluno);
//            }

//        Double percentualBase = null;
//        if (calcularAproveitamento(App.getAluno()) <= 25)
//            alunos25.add(aluno);
//
//        if (calcularAproveitamento(App.getAluno()) > 25 && calcularAproveitamento(App.getAluno()) <= 50)
//            alunos50.add(aluno);
//
//        if (calcularAproveitamento(App.getAluno()) > 50 && calcularAproveitamento(App.getAluno()) <= 75)
//            alunos75.add(aluno);
//
//        if (calcularAproveitamento(App.getAluno()) > 75)
//            alunos100.add(aluno);

        Double aproveitamento = calcularAproveitamento(App.getAluno());
        feadbackValid(aproveitamento);
        textResultAproveitamento.setTextColor(aproveitamento < 60 ? Color.RED : Color.GREEN);
        textResultAproveitamento.setText(aproveitamento+"%");
        App.getAluno().setAlunoRepository(new AlunoRepository(this));
        App.getAluno().insert();

    }

    @Override
    protected void onResume() {
        super.onResume();
        new buscaInfo().execute();
    }

    private Double calcularAproveitamento(Aluno aluno) {
        Double aproveitamento = null;
        if (aluno.getAjuda() == null && aluno.getConcorso() == null)
            aproveitamento = (aluno.getMediaAutodidata() * 0.5 + aluno.getMediaFamilia() * 0.5);

        if (aluno.getAjuda() == null && aluno.getConcorso() != null)
            aproveitamento = (App.getAluno().getMediaAutodidata() * 0.35 +
                    aluno.getMediaFamilia() * 0.35 + aluno.getMediaReforco() * 0.3);

        if (aluno.getAjuda() != null && aluno.getConcorso() == null)
            aproveitamento = (aluno.getMediaAutodidata() * 0.35 +
                    aluno.getMediaFamilia() * 0.35 + aluno.getMediaExtraCurricular() * 0.3);

        if (aluno.getAjuda() != null && aluno.getConcorso() != null)
            aproveitamento = (aluno.getMediaAutodidata() * 0.3 + aluno.getMediaFamilia() * 0.3 +
                    aluno.getMediaReforco() * 0.2 + aluno.getMediaExtraCurricular() * 0.2);

        return aproveitamento;
    }

    private void identifyVisible() {
        constraintExtra.setVisibility(App.getAluno().getAjuda() == null ? View.GONE : View.VISIBLE);

        constraintReforco.setVisibility(App.getAluno().getConcorso() == null ? View.GONE : View.VISIBLE);

    }

    private void loadText() {
        textAudicao.setText(App.getAluno().getAudicao() + "%");
        textRepeticao.setText(App.getAluno().getRepeticao() + "%");
        textVisao.setText(App.getAluno().getVisao() + "%");
        textMediaAprendizado.setText(App.getAluno().getMediaAutodidata() + "%");
        textFamiliaEspaco.setText(App.getAluno().getEspacoEstudo() + "%");
        textFamiliaMateria.setText(App.getAluno().getMaterialDidatico() + "%");
        textFamiliaMedia.setText(App.getAluno().getMediaFamilia() + "%");
        textFamiliaTempo.setText(App.getAluno().getTempoEstudo() + "%");
        textExtraAjuda.setText(App.getAluno().getAjuda() + "%");
        textExtraAuxilio.setText(App.getAluno().getAuxilioEscolar() + "%");
        textExtraMedia.setText(App.getAluno().getMediaExtraCurricular() + "%");
        textExtraTempo.setText(App.getAluno().getConsumoTempo() + "%");
        textReforcoAprendizado.setText(App.getAluno().getAprenderMais() + "%");
        textReforcoConcurso.setText(App.getAluno().getConcorso() + "%");
        textReforcoMedia.setText(App.getAluno().getMediaReforco() + "%");
        textReforcoNota.setText(App.getAluno().getMelhorarNota() + "%");
    }

    private void feadbackValid(Double aproveitamento) {
        String message;
        if (aproveitamento > 75) {
            message = "Parabéns! Está muito bem encaminhado seus estudos. Logico que sempre dá para melhorar um pouco mais, mas continue como está!";
        } else if (aproveitamento <= 75 && aproveitamento > 50) {
            message = "Tome cuidado com os detalhes. Você está indo bem, mas sempre procure melhorar, busque novos caminhos para estudar e se desenvolver mais!\n";
            if (App.getAluno().getMediaAutodidata() < 66) {
                message += "\nEstá mandando bem, mas ainda pode melhorar!\n" +
                        "Foque em aprender por:";
                if (App.getAluno().getAudicao() < 50)
                    message += "\nAudição\n";
                if (App.getAluno().getVisao() < 50)
                    message += "\nVisão\n";
                if (App.getAluno().getRepeticao() < 50)
                    message += "\nEscrita\n";
            }
            if (App.getAluno().getMediaFamilia() < 66)
                message += "\nAjuda familiar pode te auxiliar e ter um grande impacto no aprendizado!\n";
            if (App.getAluno().getMediaExtraCurricular() != null && App.getAluno().getMediaExtraCurricular() < 66)
                message += "\nMantenha o foco em suas atividades extracurriculares!\n";
            if (App.getAluno().getMediaReforco() != null && App.getAluno().getMediaReforco() < 66)
                message += "\nIntensifique seus estudos nas aulas de reforço!\n";
        } else if (aproveitamento <= 50 && aproveitamento > 25) {
            //message = "Sempre há algo que se pode melhorar. Busque novas alternativas, o caminho que está seguindo pode não ser o melhor.";
            message = "\nVocê está se esforçando, mas talvez deva seguir outros caminhos para ser um melhor autodidata.\n";
            message += "\nEstá mandando bem, mas ainda pode melhorar!\n" +
                    "Foque em aprender por:";
            if (App.getAluno().getAudicao() < 50)
                message += "\nAudição\n";
            if (App.getAluno().getVisao() < 50)
                message += "\nVisão\n";
            if (App.getAluno().getRepeticao() < 50)
                message += "\nEscrita\n";
            message += "\nAjuda familiar pode te auxiliar e ter um grande impacto no aprendizado!\n";

            if (App.getAluno().getMediaExtraCurricular() == null && App.getAluno().getMediaReforco() == null)
                message += "\nBusque realizar atividades extracurriculares e aulas de reforço!\n";
            if (App.getAluno().getMediaExtraCurricular() != null && App.getAluno().getMediaReforco() == null)
                message += "\nProcure fazer aulas de reforço!\n";
            if (App.getAluno().getMediaExtraCurricular() == null && App.getAluno().getMediaReforco() != null)
                message += "\nAtividades extracurriculares te auxiliaram no processo!\n";
        } else if (aproveitamento <= 25 && aproveitamento >= 1) {
            message = "Você não está no caminho certo e precisa mudar a forma de estudar!\n\n" +
                    "Reserve um tempo maior para os estudos e sua família será de grande ajuda no processo.";
        } else {
            message = "Há algo muito errado com você e seus estudos!\n" +
                    "Tenha um mínimo de dedicação ou nunca apresentará bons resultados.";
        }
        textResultFeadback.setText(message);
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
