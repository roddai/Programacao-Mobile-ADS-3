package com.example.aula6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando os pets
        Pet Pet1 = new Pet("Jacob", "Marrom e Branco", "Não possui", 4,"05/09/2020");
        Pet Pet2 = new Pet("Theo", "Branco", "Maltês", 4,"15/02/2021");
        Pet Pet3 = new Pet("Kiara", "Marrom", "Shih Tzu", 3,"24/05/2022");
        Pet Pet4 = new Pet("Mia", "Marrom e Branco", "Persa", 13,"05/09/2012");
        Pet Pet5 = new Pet("Marte", "Branco", "Scottish Fold", 9,"10/02/2017");
        Pet Pet6 = new Pet("Kira", "Marrom", "Angorá", 5,"09/07/2020");

        // Botões
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);

        // Listeners
        button1.setOnClickListener(v -> abrirDetalhes(Pet1));
        button2.setOnClickListener(v -> abrirDetalhes(Pet2));
        button3.setOnClickListener(v -> abrirDetalhes(Pet3));
        button4.setOnClickListener(v -> abrirDetalhes(Pet4));
        button5.setOnClickListener(v -> abrirDetalhes(Pet5));
        button6.setOnClickListener(v -> abrirDetalhes(Pet6));
    }

    private void abrirDetalhes(Pet pet) {
        Intent intent = new Intent(MainActivity.this, DetalhesPetActivity.class);
        intent.putExtra("nome", pet.getNome());
        intent.putExtra("cor", pet.getCor());
        intent.putExtra("raca", pet.getRaca());
        intent.putExtra("idade", pet.getIdade());
        intent.putExtra("nascimento", pet.getNascimento());
        startActivity(intent);
    }
}




