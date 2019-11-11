package br.com.trabalho.ia.config;

import android.app.Application;

import br.com.trabalho.ia.domain.Aluno;

public class App extends Application {

    private static App instance;
    private static RetrofitFactory retrofitFactory;
    private static Aluno aluno;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        retrofitFactory = RetrofitFactory.getInstance();
    }

    public static App getInstance() {
        return instance;
    }

    public static RetrofitFactory getRetrofitFactory() {
        return retrofitFactory;
    }

    public static Aluno getAluno() {
        return aluno;
    }

    public static void setAluno(Aluno aluno) {
        App.aluno = aluno;
    }
}
