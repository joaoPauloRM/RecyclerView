package com.example.myapplication.Activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Activity.model.Filme;
import com.example.myapplication.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listFilmes;

    public Adapter(List<Filme> lista) {
        this.listFilmes=lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup, false );
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Filme filme = listFilmes.get(i);
        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.genero.setText(filme.getGeneroFilme());
        myViewHolder.ano.setText(filme.getAnoFilme());

    }

    @Override
    public int getItemCount() {
        return listFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            genero = itemView.findViewById(R.id.textGenero);
            ano = itemView.findViewById(R.id.textAno);


        }
    }

    }


