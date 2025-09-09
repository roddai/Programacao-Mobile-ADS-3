package com.example.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criar pets de exemplo
        final Pet rex = new Pet("Rex", "Branco", "Samoyeda", 3, "15/04/2021", "Cachorro", R.drawable.rex_dog);
        final Pet thor = new Pet("Thor", "Bege", "Pug", 2, "20/08/2022", "Cachorro", R.drawable.thor_dog);
        final Pet max = new Pet("Max", "Dourado", "Golden Retriever", 2, "10/06/2022", "Cachorro", R.drawable.max_dog);
        final Pet boby = new Pet("Boby", "Branco", "Beagle", 4, "22/11/2020", "Cachorro", R.drawable.boby_dog);
        final Pet luna = new Pet("Luna", "Branco", "Siamês Lynx Point", 1, "10/12/2023", "Gato", R.drawable.luna_cat);
        final Pet mingau = new Pet("Mingau", "Laranja", "Persa", 4, "05/03/2020", "Gato", R.drawable.mingau_cat);
        final Pet simba = new Pet("Simba", "Cinza", "Tabby", 1, "30/01/2023", "Gato", R.drawable.simba_cat);
        final Pet nina = new Pet("Nina", "Cinza e Branco", "Siamês", 3, "15/09/2021", "Gato", R.drawable.nina_cat);

        // Configurar clique nos botões
        ImageView btnRex = findViewById(R.id.btn_rex);
        ImageView btnThor = findViewById(R.id.btn_thor);
        ImageView btnMax = findViewById(R.id.btn_max);
        ImageView btnBoby = findViewById(R.id.btn_boby);
        ImageView btnLuna = findViewById(R.id.btn_luna);
        ImageView btnMingau = findViewById(R.id.btn_mingau);
        ImageView btnSimba = findViewById(R.id.btn_simba);
        ImageView btnNina = findViewById(R.id.btn_nina);

        btnRex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(rex);
            }
        });

        btnThor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(thor);
            }
        });

        btnLuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(luna);
            }
        });

        btnMingau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(mingau);
            }
        });
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(max);
            }
        });

        btnBoby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(boby);
            }
        });

        btnSimba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(simba);
            }
        });

        btnNina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDetalhesPet(nina);
            }
        });
    }

    private void abrirDetalhesPet(Pet pet) {
        Intent intent = new Intent(this, DetalhesPetActivity.class);
        intent.putExtra("PET", pet);
        startActivity(intent);
    }
}