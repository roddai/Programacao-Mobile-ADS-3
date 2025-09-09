package com.example.aula6tarefa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes);

        TextView Nome1 = findViewById(R.id.nome);
        TextView Cor1 = findViewById(R.id.cor);
        TextView Raca1 = findViewById(R.id.raca);
        TextView Idade1 = findViewById(R.id.idade);

        String nome = getIntent().getStringExtra("nome");
        String cor = getIntent().getStringExtra("cor");
        String raca = getIntent().getStringExtra("raca");
        int idade = getIntent().getIntExtra("idade", -1);

        Nome1.setText(nome);
        Cor1.setText(cor);
        Raca1.setText(raca);
        Idade1.setText(String.valueOf(idade));
    }
}
