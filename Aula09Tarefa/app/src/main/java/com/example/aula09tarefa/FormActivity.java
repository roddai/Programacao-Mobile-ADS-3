package com.example.aula09tarefa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.StringJoiner;

public class FormActivity extends AppCompatActivity {

    private EditText editTextEventName, editTextEventDate, editTextComments;
    private Spinner spinnerLocation, spinnerEventType;
    private CheckBox cbSalgados, cbDoces, cbChurrasco;
    private CheckBox cbRefrigerantes, cbCervejas;
    private RadioGroup radioGroupGuests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Inicializa os componentes da UI
        initializeViews();

        // Configura os Spinners
        setupSpinners();

        // Configura os botões
        setupButtons();
    }

    private void initializeViews() {
        editTextEventName = findViewById(R.id.editTextEventName);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        editTextEventDate = findViewById(R.id.editTextEventDate);
        spinnerEventType = findViewById(R.id.spinnerEventType);
        cbSalgados = findViewById(R.id.checkBoxSalgados);
        cbDoces = findViewById(R.id.checkBoxDoces);
        cbChurrasco = findViewById(R.id.checkBoxChurrasco);
        cbRefrigerantes = findViewById(R.id.checkBoxRefrigerantes);
        cbCervejas = findViewById(R.id.checkBoxCervejas);
        radioGroupGuests = findViewById(R.id.radioGroupGuests);
        editTextComments = findViewById(R.id.editTextComments);
    }

    private void setupSpinners() {
        // Spinner de Local
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(locationAdapter);

        // Spinner de Tipo de Evento
        ArrayAdapter<CharSequence> eventTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.event_types_array, android.R.layout.simple_spinner_item);
        eventTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventType.setAdapter(eventTypeAdapter);
    }

    private void setupButtons() {
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> {
            // Finaliza a atividade atual e volta para a anterior (WelcomeActivity)
            finish();
        });

        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> {
            if (validateData()) {
                collectAndSendData();
            }
        });
    }

    private boolean validateData() {
        if (editTextEventName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, insira o nome do evento.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (editTextEventDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, insira a data do evento.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (radioGroupGuests.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecione a faixa de convidados.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void collectAndSendData() {
        // Coleta dos dados
        String eventName = editTextEventName.getText().toString();
        String location = spinnerLocation.getSelectedItem().toString();
        String eventDate = editTextEventDate.getText().toString();
        String eventType = spinnerEventType.getSelectedItem().toString();
        String comments = editTextComments.getText().toString();

        // Coleta das comidas (concatena em uma String)
        StringJoiner foodJoiner = new StringJoiner(", ");
        if (cbSalgados.isChecked()) foodJoiner.add("Salgados");
        if (cbDoces.isChecked()) foodJoiner.add("Doces");
        if (cbChurrasco.isChecked()) foodJoiner.add("Churrasco");
        String selectedFoods = foodJoiner.length() > 0 ? foodJoiner.toString() : "Nenhuma";

        // Coleta da faixa de convidados
        int selectedGuestRadioId = radioGroupGuests.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedGuestRadioId);
        String guestRange = selectedRadioButton.getText().toString();

        // Cria o Intent para a SummaryActivity
        Intent intent = new Intent(FormActivity.this, SummaryActivity.class);

        // Adiciona os dados como "extras" no Intent
        intent.putExtra("EVENT_NAME", eventName);
        intent.putExtra("LOCATION", location);
        intent.putExtra("EVENT_DATE", eventDate);
        intent.putExtra("EVENT_TYPE", eventType);
        intent.putExtra("SELECTED_FOODS", selectedFoods);
        intent.putExtra("GUEST_RANGE", guestRange);
        intent.putExtra("COMMENTS", comments);

        // Inicia a próxima atividade
        startActivity(intent);
    }
}