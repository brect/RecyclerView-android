package br.com.blimas.recyclerview.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.blimas.recyclerview.R;
import br.com.blimas.recyclerview.model.Filme;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    private List<Filme> listaFilmes;

    public AdapterFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Converte xml adapter_lista_filmes para poder utilizar na visualizacao
        View itemFilmeLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_filmes, parent, false);

        //cria a vizualização dos itens
        return new MyViewHolder(itemFilmeLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //recupera posicao do filme na lista
        Filme filme = listaFilmes.get(position);

//        holder.titulo.setText("Titulo do Filme");
//        holder.ano.setText("Ano do Filme");
//        holder.genero.setText("Genero do Filme");
        holder.titulo.setText(filme.getTitulo());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //configura infomacoes do objeto
            titulo = itemView.findViewById(R.id.titulo_filme_adapter);
            ano = itemView.findViewById(R.id.ano_filme_adapter);
            genero = itemView.findViewById(R.id.genero_filme_adapter);

        }
    }

}


