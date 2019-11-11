package br.com.trabalho.ia.ui;

import br.com.trabalho.ia.ui.autodidata.QuestionAutodidata;

public class IDashboard {
    public interface View{

        void navigationToQuestion(Class<QuestionAutodidata> questionAutodidataClass);
    }
    public interface Presenter{

        void clickAdd();
    }
}
