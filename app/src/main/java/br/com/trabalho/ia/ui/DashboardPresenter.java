package br.com.trabalho.ia.ui;

import br.com.trabalho.ia.config.App;
import br.com.trabalho.ia.domain.Aluno;
import br.com.trabalho.ia.ui.autodidata.QuestionAutodidata;

public class DashboardPresenter implements IDashboard.Presenter {

    private IDashboard.View view;

    public DashboardPresenter(IDashboard.View view) {
        this.view = view;
    }

    @Override
    public void clickAdd() {
        App.setAluno(new Aluno());
        view.navigationToQuestion(QuestionAutodidata.class);
    }
}
