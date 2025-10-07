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
        TextView tvEventName = findViewById(R.id.textViewValueEventName);
        TextView tvLocation = findViewById(R.id.textViewValueLocation);
        TextView tvEventDate = findViewById(R.id.textViewValueDate);
        TextView tvEventType = findViewById(R.id.textViewValueEventType);
        TextView tvFoods = findViewById(R.id.textViewValueFoods);
        TextView tvGuests = findViewById(R.id.textViewValueGuests);
        TextView tvComments = findViewById(R.id.textViewValueComments);
        Button buttonBack = findViewById(R.id.buttonBackToForm);

        // Pega o Intent que iniciou esta atividade
        Intent intent = getIntent();

        // Extrai os dados do Intent usando as chaves definidas na FormActivity
        String eventName = intent.getStringExtra("EVENT_NAME");
        String location = intent.getStringExtra("LOCATION");
        String eventDate = intent.getStringExtra("EVENT_DATE");
        String eventType = intent.getStringExtra("EVENT_TYPE");
        String selectedFoods = intent.getStringExtra("SELECTED_FOODS");
        String guestRange = intent.getStringExtra("GUEST_RANGE");
        String comments = intent.getStringExtra("COMMENTS");

        // Define os textos nos TextViews com os dados recebidos
        tvEventName.setText(eventName);
        tvLocation.setText(location);
        tvEventDate.setText(eventDate);
        tvEventType.setText(eventType);
        tvFoods.setText(selectedFoods);
        tvGuests.setText(guestRange);
        tvComments.setText(comments);

        // Configura o botão de voltar
        buttonBack.setOnClickListener(v -> {
            // Finaliza a atividade atual, retornando para a FormActivity
            finish();
        });
    }
}