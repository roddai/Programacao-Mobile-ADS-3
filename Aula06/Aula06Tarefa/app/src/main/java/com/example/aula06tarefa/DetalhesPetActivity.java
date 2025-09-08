package com.example.aula06tarefa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView nomeView, corView, racaView, idadeView, aniverView;
        ImageView imageView;

        nomeView = findViewById(R.id.nomeId);
        corView = findViewById(R.id.corId);
        racaView = findViewById(R.id.racaId);
        idadeView = findViewById(R.id.idadeId);
        aniverView = findViewById(R.id.aniverId);
        imageView = findViewById(R.id.imageView);

        String nome = getIntent().getStringExtra("nome");
        String cor = getIntent().getStringExtra("cor");
        String raca = getIntent().getStringExtra("raca");
        int idade = getIntent().getIntExtra("idade", 0);
        String aniversario = getIntent().getStringExtra("aniversario");
        int imagemId = getIntent().getIntExtra("imagem", R.drawable.pet1);

        nomeView.setText("Nome: " + nome);
        corView.setText("Cor: " + cor);
        racaView.setText("Raça: " + raca);
        idadeView.setText("Idade: " + idade);
        aniverView.setText("Aniversário: " + aniversario);
        imageView.setImageResource(imagemId);
    }
}