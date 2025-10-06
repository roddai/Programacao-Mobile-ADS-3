package com.example.aula09tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Encontra os TextViews no layout
        TextView tvEventName = findViewById(R.id.textViewEventNameValue);
        TextView tvLocation = findViewById(R.id.textViewLocationValue);
        TextView tvDate = findViewById(R.id.textViewDateValue);
        TextView tvEventType = findViewById(R.id.textViewTypeValue);
        TextView tvFoods = findViewById(R.id.textViewFoodsValue);
        TextView tvDrinks = findViewById(R.id.textViewDrinksValue);
        TextView tvGuests = findViewById(R.id.textViewGuestsValue);
        TextView tvComment = findViewById(R.id.textViewCommentValue);
        Button buttonBack = findViewById(R.id.buttonBackSummary);

        // Pega a Intent que iniciou esta atividade
        Intent intent = getIntent();

        // Extrai os dados da Intent e os exibe nos TextViews
        tvEventName.setText(intent.getStringExtra("EVENT_NAME"));
        tvLocation.setText(intent.getStringExtra("LOCATION"));
        tvDate.setText(intent.getStringExtra("DATE"));
        tvEventType.setText(intent.getStringExtra("EVENT_TYPE"));
        tvFoods.setText(intent.getStringExtra("FOODS"));
        tvDrinks.setText(intent.getStringExtra("DRINKS"));
        tvGuests.setText(intent.getStringExtra("GUESTS"));
        tvComment.setText(intent.getStringExtra("COMMENT"));

        // Configura o botão Voltar para finalizar a atividade e retornar à tela de formulário
        buttonBack.setOnClickListener(view -> finish());
    }
}
