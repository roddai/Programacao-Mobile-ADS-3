package com.example.aula06tarefa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    // Pets instanciados com dados fictícios
    Pet rex = new Pet("Rex", "Marrom", "Labrador", 5, "15/04/2018");
    Pet thor = new Pet("Thor", "Preto", "Pastor Alemão", 4, "23/07/2019");
    Pet luna = new Pet("Luna", "Branco", "Persa", 2, "01/01/2021");
    Pet mimi = new Pet("Mimi", "Cinza", "Siamês", 3, "10/05/2020");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botões
        Button btnRex = findViewById(R.id.btnRex);
        Button btnThor = findViewById(R.id.btnThor);
        Button btnLuna = findViewById(R.id.btnLuna);
        Button btnMimi = findViewById(R.id.btnMimi);

        // Cada botão envia os dados do pet via Intent
        btnRex.setOnClickListener(v -> abrirDetalhes(rex, R.drawable.img));
        btnThor.setOnClickListener(v -> abrirDetalhes(thor, R.drawable.img_1));
        btnLuna.setOnClickListener(v -> abrirDetalhes(luna, R.drawable.img_4));
        btnMimi.setOnClickListener(v -> abrirDetalhes(mimi, R.drawable.img_5));
    }

    private void abrirDetalhes(Pet pet, int imagemId) {
        Intent intent = new Intent(this, DetalhesPetActivity.class);
        intent.putExtra("pet", pet);  // pet deve ser Parcelable agora
        startActivity(intent);
        intent.putExtra("imagem", imagemId);
        startActivity(intent);
    }
}