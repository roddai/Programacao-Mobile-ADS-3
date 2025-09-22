package com.example.aula6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView nome = findViewById(R.id.nome);
        TextView cor = findViewById(R.id.cor);
        TextView raca = findViewById(R.id.raca);
        TextView idade = findViewById(R.id.idade);
        TextView nascimento = findViewById(R.id.nascimento);

        // Recebendo dados da MainActivity
        nome.setText("Nome: " + getIntent().getStringExtra("nome"));
        cor.setText("Cor: " + getIntent().getStringExtra("cor"));
        raca.setText("Raça: " + getIntent().getStringExtra("raca"));
        idade.setText("Idade: " + getIntent().getIntExtra("idade", 0) + " anos");
        nascimento.setText("Nascimento: " + getIntent().getStringExtra("nascimento"));
    }
}
