package com.example.aula09;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_summary);

            TextView tvResultado = findViewById(R.id.tvResultado);
            Button btnVoltar = findViewById(R.id.btnVoltar);

            String resultado = getIntent().getStringExtra("resultado");
            tvResultado.setText(resultado);

            btnVoltar.setOnClickListener(v -> finish());
        }
    }
