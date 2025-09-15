package com.example.java_aula_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pet thug = new Pet("Thug", "Caramelo", "Sem raça definida", 6, "20 de julho", R.drawable.thug, "Macho");
        Pet boris = new Pet("Boris", "Preto e Marrom", "Sem raça definida", 1, "10 de julho", R.drawable.boris, "Macho");
        Pet amora = new Pet("Amora", "Pretusca", "Sem raça definida", 3, "5 de janeiro", R.drawable.amora, "Fêmea");

        Button btnThug = findViewById(R.id.btnThug);
        btnThug.setOnClickListener(v -> irParaDetalhes(thug));

        Button btnBoris = findViewById(R.id.btnBoris);
        btnBoris.setOnClickListener(v -> irParaDetalhes(boris));

        Button btnAmora = findViewById(R.id.btnAmora);
        btnAmora.setOnClickListener(v -> irParaDetalhes(amora));
    }

    private void irParaDetalhes(Pet pet) {
        Intent intent = new Intent(this, DetalhesPetActivity.class);
        intent.putExtra("pet", pet);
        startActivity(intent);
    }
}
