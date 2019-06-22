package com.example.myapplication.Activity.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Activity.RecyclerItemClickListener;
import com.example.myapplication.Activity.adapter.Adapter;
import com.example.myapplication.Activity.model.Filme;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lista;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.recyclerView);

        this.criarFilmes();


        //Configurar Adapter

        Adapter adapter = new Adapter(listaFilmes);


        //Configurar Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
        lista.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        lista.setAdapter(adapter);

        lista.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        lista, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme f = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), f.getTituloFilme(), Toast.LENGTH_SHORT ).show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
                )

        );

    }



    public void criarFilmes() {

        Filme filme = new Filme("Terminator 2: Judgment Day", "Sci-fi", "1991");
        this.listaFilmes.add(filme);
        filme = new Filme("Lord of the Rings: The Return of the King", "Fantasy", "2003");
        this.listaFilmes.add(filme);
        filme = new Filme("Mad Max 2: The Road Warrior", "Action", "1982");
        this.listaFilmes.add(filme);


    }

}
