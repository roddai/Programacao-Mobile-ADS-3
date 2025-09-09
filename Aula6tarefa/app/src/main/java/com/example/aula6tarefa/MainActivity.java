package com.example.aula6tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Pet cachorro1, cachorro2, cachorro3;
    Button camila, nina, roberta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        camila = findViewById(R.id.camila);
        nina = findViewById(R.id.nina);
        roberta = findViewById(R.id.roberta);

        cachorro1 = new Pet("Camila", "Mofada", "Demoníaca", 8);
        cachorro2 = new Pet("Nina", "Caramela", "Linguiça", 3);
        cachorro3 = new Pet("Roberta", "Branca com laranja", "Aquela mesmo", 99);

        camila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalhesPetActivity.class);
                intent.putExtra("nome", cachorro1.Nome);
                intent.putExtra("cor", cachorro1.Cor);
                intent.putExtra("raca", cachorro1.Raca);
                intent.putExtra("idade", cachorro1.Idade);
                startActivity(intent);
            }
        });

        nina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalhesPetActivity.class);
                intent.putExtra("nome", cachorro2.Nome);
                intent.putExtra("cor", cachorro2.Cor);
                intent.putExtra("raca", cachorro2.Raca);
                intent.putExtra("idade", cachorro2.Idade);
                startActivity(intent);
            }
        });

        roberta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalhesPetActivity.class);
                intent.putExtra("nome", cachorro3.Nome);
                intent.putExtra("cor", cachorro3.Cor);
                intent.putExtra("raca", cachorro3.Raca);
                intent.putExtra("idade", cachorro3.Idade);
                startActivity(intent);
            }
        });
    }
}
