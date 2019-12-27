package br.com.blimas.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.blimas.recyclerview.R;
import br.com.blimas.recyclerview.adapter.AdapterFilmes;
import br.com.blimas.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilmes = findViewById(R.id.recyclerView);

        //Listagem dos filmes
        this.criarFilmes();

        //Configura adapter
        AdapterFilmes adapter = new AdapterFilmes(listaFilmes);

        //Configura Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFilmes.setLayoutManager(layoutManager);
        recyclerViewFilmes.setHasFixedSize(true);

        //configura linha de divisao da lista
        recyclerViewFilmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewFilmes.setAdapter( adapter );
    }

    public void criarFilmes(){

        //Cria filmes
        for (int i = 0; i < 20; i++){
            Filme filme = new Filme("Titulo " + i, "genero " + i, "ano " + i);
            this.listaFilmes.add( filme );
        }

    }
}
