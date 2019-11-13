package br.com.trabalho.ia.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.domain.Aluno;
import br.com.trabalho.ia.repository.AlunoRepository;

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.DashboardViewHolder> {

    private Context context;
    private List<Aluno> alunos;

    public AdapterDashboard(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_busca, viewGroup, false);
        return new DashboardViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        Aluno aluno = alunos.get(position);
        holder.vincular(aluno);
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

    public Aluno getAluno(int position) {

        return alunos.get(position);
    }

    public void remove(final int position, final Aluno aluno) {
        new AlertDialog.Builder(context)
                .setTitle("Deletando Livro")
                .setMessage("Tem certeza que deseja deletar esse livros?")
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //GerenciarLivroDao.remolveLivro(adapterPosition);
                        new AlunoRepository(context).delete(aluno);
                        alunos.remove(aluno);
                        notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notifyDataSetChanged();
                    }
                })
                .show();
    }

    public class DashboardViewHolder extends RecyclerView.ViewHolder{

        private TextView textAproveitamento;
        private TextView textAutodidata;
        private TextView textFamilia;
        private Aluno aluno;
        private Double aproveitamento;
        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);
            textAproveitamento = itemView.findViewById(R.id.text_aproveitamento);
            textAutodidata = itemView.findViewById(R.id.text_nivel_autodidata);
            textFamilia = itemView.findViewById(R.id.text_suporte_familiar);
        }

        public void vincular(Aluno aluno){
            if (aluno.getAjuda() == null && aluno.getConcorso() == null)
                aproveitamento = (aluno.getMediaAutodidata() * 0.5 + aluno.getMediaFamilia() * 0.5);

            if (aluno.getAjuda() == null && aluno.getConcorso() != null)
                aproveitamento = (aluno.getMediaAutodidata() * 0.35 +
                        aluno.getMediaFamilia() * 0.35 + aluno.getMediaReforco() * 0.3);

            if (aluno.getAjuda() != null && aluno.getConcorso() == null)
                aproveitamento = (aluno.getMediaAutodidata() * 0.35 +
                        aluno.getMediaFamilia() * 0.35 + aluno.getMediaExtraCurricular() * 0.3);

            if (aluno.getAjuda() != null &&aluno.getConcorso() != null)
                aproveitamento = (aluno.getMediaAutodidata() * 0.3 + aluno.getMediaFamilia() * 0.3 +
                        aluno.getMediaReforco() * 0.2 + aluno.getMediaExtraCurricular() * 0.2);

            if (aproveitamento < 60)
                textAproveitamento.setTextColor(Color.RED);
            else textAproveitamento.setTextColor(Color.GREEN);

            textAproveitamento.setText(aproveitamento + "%");
            textAutodidata.setText(aluno.getMediaAutodidata() +"%");
            textFamilia.setText(aluno.getMediaFamilia() +"%");
            this.aluno = aluno;
        }
    }
}
