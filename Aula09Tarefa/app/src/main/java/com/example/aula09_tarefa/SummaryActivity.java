package com.example.aula09_tarefa;



import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aula09_tarefa.R;

public class SummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvResumo = findViewById(R.id.tvResumo);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        String resumo = "Evento: " + getIntent().getStringExtra("nome") +
                "\nData: " + getIntent().getStringExtra("data") +
                "\nLocal: " + getIntent().getStringExtra("local") +
                "\nTipo: " + getIntent().getStringExtra("tipo") +
                "\nComidas: " + getIntent().getStringExtra("comidas") +
                "\nBebidas: " + getIntent().getStringExtra("bebidas") +
                "\nConvidados: " + getIntent().getStringExtra("convidados") +
                "\nComentário: " + getIntent().getStringExtra("comentario");

        tvResumo.setText(resumo);

        btnVoltar.setOnClickListener(v -> finish());
    }
}
