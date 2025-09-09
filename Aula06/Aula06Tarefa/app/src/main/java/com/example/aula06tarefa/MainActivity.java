package com.example.aula06tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Pet cao1, cao2, cao3;
    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Instanciando os livros */
        cao1 = new Pet("Harvy", "Branco","Lulu", 2,"21/05/2023");
        cao2 = new Pet("Pandora", "Champanhe","Lulu", 2,"10/02/2020");
        cao3 = new Pet("Pipoca", "Chocolate","Lulu", 2,"22/08/2023");

        textInfo = findViewById(R.id.textInfo);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> abrirDetalhes(cao1));
        button2.setOnClickListener(v -> abrirDetalhes(cao2));
        button3.setOnClickListener(v -> abrirDetalhes(cao3));
    }
    private void abrirDetalhes(Pet pet){
        Intent intent= new Intent(MainActivity.this, DetalhesPetActivity.class);
        intent.putExtra("nome", pet.nome);
        intent.putExtra("cor", pet.cor);
        intent.putExtra("raca", pet.raca);
        intent.putExtra("idade", pet.idade);
        intent.putExtra("aniversario", pet.aniversario);
        // intent.putExtra("imagem", drawableId);
        startActivity(intent);

    }

}