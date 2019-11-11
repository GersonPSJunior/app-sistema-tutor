package br.com.trabalho.ia.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.trabalho.ia.R;
import br.com.trabalho.ia.domain.Aluno;

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

    public class DashboardViewHolder extends RecyclerView.ViewHolder{

        private TextView textAproveitamento;
        private TextView textAutodidata;
        private TextView textFamilia;
        private Aluno aluno;
        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);
            textAproveitamento = itemView.findViewById(R.id.text_aproveitamento);
            textAutodidata = itemView.findViewById(R.id.text_nivel_autodidata);
            textFamilia = itemView.findViewById(R.id.text_suporte_familiar);
        }

        public void vincular(Aluno aluno){
            if ((aluno.getMediaAutodidata() + aluno.getMediaFamilia())/2 < 60)
                textAproveitamento.setTextColor(Color.RED);
            textAproveitamento.setText((aluno.getMediaAutodidata() + aluno.getMediaFamilia())/2 + "%");
            textAutodidata.setText(aluno.getMediaAutodidata() +"%");
            textFamilia.setText(aluno.getMediaFamilia() +"%");
        }
    }
}
