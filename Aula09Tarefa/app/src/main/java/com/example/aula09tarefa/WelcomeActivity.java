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

        Button buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(v -> {
            // Cria um Intent para iniciar a FormActivity
            Intent intent = new Intent(WelcomeActivity.this, FormActivity.class);
            startActivity(intent);
        });
    }
}