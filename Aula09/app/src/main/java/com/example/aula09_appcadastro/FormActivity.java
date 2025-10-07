package com.example.aula09_appcadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText eventName, eventDate, comment;
    private Spinner locationSpinner, typeSpinner;
    private CheckBox foodSalgados, foodDoces, foodChurrasco, foodNenhuma;
    private CheckBox drinkRefrigerantes, drinkCervejas, drinkVodkas, drinkNenhuma;
    private RadioGroup guestGroup;
    private Button backButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Inicializa componentes
        eventName = findViewById(R.id.eventName);
        eventDate = findViewById(R.id.eventDate);
        comment = findViewById(R.id.comment);
        locationSpinner = findViewById(R.id.locationSpinner);
        typeSpinner = findViewById(R.id.typeSpinner);
        foodSalgados = findViewById(R.id.foodSalgados);
        foodDoces = findViewById(R.id.foodDoces);
        foodChurrasco = findViewById(R.id.foodChurrasco);
        foodNenhuma = findViewById(R.id.foodNenhuma);
        drinkRefrigerantes = findViewById(R.id.drinkRefrigerantes);
        drinkCervejas = findViewById(R.id.drinkCervejas);
        drinkVodkas = findViewById(R.id.drinkVodkas);
        drinkNenhuma = findViewById(R.id.drinkNenhuma);
        guestGroup = findViewById(R.id.guestGroup);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        // Configura Spinner Location
        String[] locations = {"São Paulo", "Rio de Janeiro", "Porto Alegre", "Belo Horizonte"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        // Configura Spinner Tipo de Evento
        String[] types = {"Aniversário", "Casamento", "Corporativo", "Outro"};
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        // Botão voltar: volta para WelcomeActivity
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(FormActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Botão próximo: valida e envia dados para SummaryActivity
        nextButton.setOnClickListener(v -> {
            if (validateForm()) {
                Intent intent = new Intent(FormActivity.this, ResumoActivity.class);

                // Pega dados do formulário
                String name = eventName.getText().toString();
                String location = locationSpinner.getSelectedItem().toString();
                String date = eventDate.getText().toString();
                String type = typeSpinner.getSelectedItem().toString();
                String foods = getSelectedFoods();
                String drinks = getSelectedDrinks();
                String guests = getSelectedGuests();
                String userComment = comment.getText().toString();

                // Passa dados via intent
                intent.putExtra("eventName", name);
                intent.putExtra("location", location);
                intent.putExtra("date", date);
                intent.putExtra("type", type);
                intent.putExtra("foods", foods);
                intent.putExtra("drinks", drinks);
                intent.putExtra("guests", guests);
                intent.putExtra("comment", userComment);

                startActivity(intent);
            }
        });
    }

    private boolean validateForm() {
        if (eventName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Informe o nome do evento", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (eventDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Informe a data do evento", Toast.LENGTH_SHORT).show();
            return false;
        }
        // Verifica se algum radio button está selecionado
        if (guestGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecione a faixa de convidados", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private String getSelectedFoods() {
        StringBuilder sb = new StringBuilder();
        if (foodSalgados.isChecked()) sb.append("Salgados, ");
        if (foodDoces.isChecked()) sb.append("Doces, ");
        if (foodChurrasco.isChecked()) sb.append("Churrasco, ");
        if (foodNenhuma.isChecked()) sb.append("Nenhuma, ");
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // remove última vírgula e espaço
        }
        return sb.toString();
    }

    private String getSelectedDrinks() {
        StringBuilder sb = new StringBuilder();
        if (drinkRefrigerantes.isChecked()) sb.append("Refrigerantes, ");
        if (drinkCervejas.isChecked()) sb.append("Cervejas, ");
        if (drinkVodkas.isChecked()) sb.append("Vodkas, ");
        if (drinkNenhuma.isChecked()) sb.append("Nenhuma, ");
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private String getSelectedGuests() {
        int selectedId = guestGroup.getCheckedRadioButtonId();
        RadioButton selectedRadio = findViewById(selectedId);
        return selectedRadio.getText().toString();
    }
}
