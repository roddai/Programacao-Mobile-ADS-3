package com.example.aula09tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView txtSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        txtSummary = findViewById(R.id.txtSummary);
        Button btnBackToForm = findViewById(R.id.btnBackToForm);

        displaySummary();

        btnBackToForm.setOnClickListener(v -> {
            finish(); // Volta para a tela anterior (FormActivity)
        });
    }

    private void displaySummary() {
        Intent intent = getIntent();

        StringBuilder summary = new StringBuilder();
        summary.append("Nome: ").append(intent.getStringExtra("EVENT_NAME")).append("\n\n");
        summary.append("Local: ").append(intent.getStringExtra("LOCATION")).append("\n\n");
        summary.append("Data: ").append(intent.getStringExtra("DATE")).append("\n\n");
        summary.append("Tipo: ").append(intent.getStringExtra("EVENT_TYPE")).append("\n\n");

        String foods = intent.getStringExtra("FOODS");
        summary.append("Comidas: ").append(foods.isEmpty() ? "Nenhuma" : foods).append("\n\n");

        String drinks = intent.getStringExtra("DRINKS");
        summary.append("Bebidas: ").append(drinks.isEmpty() ? "Nenhuma" : drinks).append("\n\n");

        summary.append("Convidados: ").append(intent.getStringExtra("GUESTS")).append("\n\n");
        summary.append("Comentário: ").append(intent.getStringExtra("COMMENT"));

        txtSummary.setText(summary.toString());
    }
}