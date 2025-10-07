package com.example.aula9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        Button btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this , FormActivity.class);
            startActivity(intent);
        });
    }
}