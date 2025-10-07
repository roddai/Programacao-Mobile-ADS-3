package com.example.aula09tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText editEventName, editDate, editComment;
    private Spinner spinnerLocation, spinnerEventType;
    private CheckBox checkSalty, checkSweets, checkBarbecue;
    private CheckBox checkSoda, checkBeer, checkVodka;
    private RadioGroup radioGuests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Encontrar views
        editEventName = findViewById(R.id.editEventName);
        editDate = findViewById(R.id.editDate);
        editComment = findViewById(R.id.editComment);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerEventType = findViewById(R.id.spinnerEventType);
        checkSalty = findViewById(R.id.checkSalty);
        checkSweets = findViewById(R.id.checkSweets);
        checkBarbecue = findViewById(R.id.checkBarbecue);
        checkSoda = findViewById(R.id.checkSoda);
        checkBeer = findViewById(R.id.checkBeer);
        checkVodka = findViewById(R.id.checkVodka);
        radioGuests = findViewById(R.id.radioGuests);

        // Configurar spinners
        setupSpinners();

        // Botões
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(FormActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        });

        btnNext.setOnClickListener(v -> {
            if (validateForm()) {
                sendDataToSummary();
            }
        });
    }

    private void setupSpinners() {
        // Local
        String[] locations = {"São Paulo", "Rio de Janeiro", "Porto Alegre", "Belo Horizonte"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(locationAdapter);

        // Tipo de evento
        String[] eventTypes = {"Aniversário", "Casamento", "Corporativo", "Outro"};
        ArrayAdapter<String> eventTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, eventTypes);
        eventTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventType.setAdapter(eventTypeAdapter);
    }

    private boolean validateForm() {
        if (editEventName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o nome do evento", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (editDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite a data do evento", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (radioGuests.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecione o número de convidados", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void sendDataToSummary() {
        Intent intent = new Intent(FormActivity.this, SummaryActivity.class);

        // Dados básicos
        intent.putExtra("EVENT_NAME", editEventName.getText().toString());
        intent.putExtra("DATE", editDate.getText().toString());
        intent.putExtra("LOCATION", spinnerLocation.getSelectedItem().toString());
        intent.putExtra("EVENT_TYPE", spinnerEventType.getSelectedItem().toString());
        intent.putExtra("COMMENT", editComment.getText().toString());

        // Comidas
        StringBuilder foods = new StringBuilder();
        if (checkSalty.isChecked()) foods.append("Salgados, ");
        if (checkSweets.isChecked()) foods.append("Doces, ");
        if (checkBarbecue.isChecked()) foods.append("Churrasco, ");
        if (foods.length() > 0) foods.setLength(foods.length() - 2);
        intent.putExtra("FOODS", foods.toString());

        // Bebidas
        StringBuilder drinks = new StringBuilder();
        if (checkSoda.isChecked()) drinks.append("Refrigerantes, ");
        if (checkBeer.isChecked()) drinks.append("Cervejas, ");
        if (checkVodka.isChecked()) drinks.append("Vodkas, ");
        if (drinks.length() > 0) drinks.setLength(drinks.length() - 2);
        intent.putExtra("DRINKS", drinks.toString());

        // Convidados
        int selectedId = radioGuests.getCheckedRadioButtonId();
        String guests = "";
        if (selectedId == R.id.radioUpTo50) guests = "Até 50 pessoas";
        else if (selectedId == R.id.radio51to100) guests = "51 a 100 pessoas";
        else if (selectedId == R.id.radioOver100) guests = "Mais de 100 pessoas";
        intent.putExtra("GUESTS", guests);

        startActivity(intent);
    }
}