package com.example.aula09_appcadastro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    private TextView tvName, tvLocation, tvDate, tvType, tvFoods, tvDrinks, tvGuests, tvComment;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        tvName = findViewById(R.id.tvName);
        tvLocation = findViewById(R.id.tvLocation);
        tvDate = findViewById(R.id.tvDate);
        tvType = findViewById(R.id.tvType);
        tvFoods = findViewById(R.id.tvFoods);
        tvDrinks = findViewById(R.id.tvDrinks);
        tvGuests = findViewById(R.id.tvGuests);
        tvComment = findViewById(R.id.tvComment);
        backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();

        tvName.setText("Nome do Evento: " + intent.getStringExtra("eventName"));
        tvLocation.setText("Local: " + intent.getStringExtra("location"));
        tvDate.setText("Data: " + intent.getStringExtra("date"));
        tvType.setText("Tipo do Evento: " + intent.getStringExtra("type"));
        tvFoods.setText("Comidas: " + intent.getStringExtra("foods"));
        tvDrinks.setText("Bebidas: " + intent.getStringExtra("drinks"));
        tvGuests.setText("Faixa de Convidados: " + intent.getStringExtra("guests"));
        tvComment.setText("Comentário: " + intent.getStringExtra("comment"));

        backButton.setOnClickListener(v -> {
            // Volta para o formulário para editar
            Intent backIntent = new Intent(ResumoActivity.this, FormActivity.class);
            startActivity(backIntent);
            finish();
        });
    }
}