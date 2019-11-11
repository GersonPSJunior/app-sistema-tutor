package br.com.trabalho.ia.repository;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.trabalho.ia.config.IManagerAlunoDao;
import br.com.trabalho.ia.config.SistemaTutorDatabase;
import br.com.trabalho.ia.domain.Aluno;

public class AlunoRepository implements IAlunoRepository {

    private IManagerAlunoDao dao;

    public AlunoRepository(Context context) {
        dao = SistemaTutorDatabase.getInstance(context).dao();
    }

    @Override
    public void insert(Aluno aluno) {
        new AsyncTaskInsert().execute(aluno);
    }

    @Override
    public void update(Aluno aluno) {
        new AsyncTaskUpdate().execute(aluno);
    }

    @Override
    public void delete(Aluno aluno) {
        new AsyncTaskDelete().execute(aluno);
    }

    @Override
    public List<Aluno> listAll() {
        try {
            return new AsyncTaskListAll().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class AsyncTaskInsert extends AsyncTask<Aluno, Void, Void>{

        @Override
        protected Void doInBackground(Aluno... alunos) {
            dao.insert(alunos[0]);
            return null;
        }
    }
    class AsyncTaskUpdate extends AsyncTask<Aluno, Void, Void>{

        @Override
        protected Void doInBackground(Aluno... alunos) {
            dao.update(alunos[0]);
            return null;
        }
    }
    class AsyncTaskDelete extends AsyncTask<Aluno, Void, Void>{

        @Override
        protected Void doInBackground(Aluno... alunos) {
            dao.delete(alunos[0]);
            return null;
        }
    }
    class AsyncTaskListAll extends AsyncTask<Void, Void, List<Aluno>>{
        @Override
        protected List<Aluno> doInBackground(Void... voids) {
            return dao.listAll();
        }
    }
}
