package com.example.aula09tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Encontra o botão "Começar" no layout
        Button buttonStart = findViewById(R.id.buttonStart);

        // Define um listener de clique para o botão
        buttonStart.setOnClickListener(view -> {
            // Cria uma Intent para iniciar a FormActivity (Tela 2)
            Intent intent = new Intent(WelcomeActivity.this, FormActivity.class);
            startActivity(intent);
        });
    }
}
