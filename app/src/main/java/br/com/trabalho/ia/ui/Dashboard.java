package br.com.trabalho.ia.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.domain.Aluno;
import br.com.trabalho.ia.repository.AlunoRepository;
import br.com.trabalho.ia.ui.adapter.AdapterDashboard;
import br.com.trabalho.ia.ui.autodidata.QuestionAutodidata;

public class Dashboard extends AppCompatActivity implements IDashboard.View{

    private IDashboard.Presenter presenter;
    private List<Aluno> alunos;
    private AdapterDashboard adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Button buttonInsert = findViewById(R.id.button_insert);

        presenter = new DashboardPresenter(this);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickAdd();
            }
        });

        configuraRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraRecyclerView();
    }

    private void configuraRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_dashboard);

        alunos = new AlunoRepository(this).listAll();
        adapter = new AdapterDashboard(this, alunos);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                adapter.remove(position, adapter.getAluno(position));
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void navigationToQuestion(Class<QuestionAutodidata> questionAutodidataClass) {
        startActivity(new Intent(this, questionAutodidataClass));
    }
}
