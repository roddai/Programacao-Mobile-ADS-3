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
import java.util.List;

public class FormActivity extends AppCompatActivity {

    private EditText editTextEventName, editTextDate, editTextComment;
    private Spinner spinnerLocation, spinnerEventType;
    private CheckBox cbSalgados, cbDoces, cbChurrasco, cbNenhumaComida;
    private CheckBox cbRefrigerantes, cbCervejas, cbVodkas, cbNenhumaBebida;
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
        editTextDate = findViewById(R.id.editTextDate);
        editTextComment = findViewById(R.id.editTextComment);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerEventType = findViewById(R.id.spinnerEventType);
        cbSalgados = findViewById(R.id.checkBoxSalgados);
        cbDoces = findViewById(R.id.checkBoxDoces);
        cbChurrasco = findViewById(R.id.checkBoxChurrasco);
        cbNenhumaComida = findViewById(R.id.checkBoxNenhumaComida);
        cbRefrigerantes = findViewById(R.id.checkBoxRefrigerantes);
        cbCervejas = findViewById(R.id.checkBoxCervejas);
        cbVodkas = findViewById(R.id.checkBoxVodkas);
        cbNenhumaBebida = findViewById(R.id.checkBoxNenhumaBebida);
        radioGroupGuests = findViewById(R.id.radioGroupGuests);
    }

    private void setupSpinners() {
        // Adaptador para o Spinner de Local
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(locationAdapter);

        // Adaptador para o Spinner de Tipo de Evento
        ArrayAdapter<CharSequence> eventTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.event_types_array, android.R.layout.simple_spinner_item);
        eventTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventType.setAdapter(eventTypeAdapter);
    }

    private void setupButtons() {
        Button buttonBack = findViewById(R.id.buttonBackForm);
        Button buttonNext = findViewById(R.id.buttonNextForm);

        // Botão Voltar: finaliza a atividade atual e volta para a tela anterior
        buttonBack.setOnClickListener(view -> finish());

        // Botão Próximo: coleta os dados e envia para a tela de resumo
        buttonNext.setOnClickListener(view -> {
            if (validateForm()) {
                collectAndSendData();
            }
        });
    }

    private boolean validateForm() {
        if (editTextEventName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, informe o nome do evento.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (editTextDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, informe a data do evento.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (radioGroupGuests.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecione a faixa de convidados.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void collectAndSendData() {
        // Coleta os dados dos campos
        String eventName = editTextEventName.getText().toString();
        String location = spinnerLocation.getSelectedItem().toString();
        String date = editTextDate.getText().toString();
        String eventType = spinnerEventType.getSelectedItem().toString();
        String comment = editTextComment.getText().toString();

        // Coleta as comidas selecionadas
        List<String> foods = new ArrayList<>();
        if (cbSalgados.isChecked()) foods.add("Salgados");
        if (cbDoces.isChecked()) foods.add("Doces");
        if (cbChurrasco.isChecked()) foods.add("Churrasco");
        if (cbNenhumaComida.isChecked()) foods.add("Nenhuma");
        String selectedFoods = String.join(", ", foods);
        if (selectedFoods.isEmpty()) selectedFoods = "Nenhuma comida selecionada";


        // Coleta as bebidas selecionadas
        List<String> drinks = new ArrayList<>();
        if (cbRefrigerantes.isChecked()) drinks.add("Refrigerantes");
        if (cbCervejas.isChecked()) drinks.add("Cervejas");
        if (cbVodkas.isChecked()) drinks.add("Vodkas");
        if (cbNenhumaBebida.isChecked()) drinks.add("Nenhuma");
        String selectedDrinks = String.join(", ", drinks);
        if (selectedDrinks.isEmpty()) selectedDrinks = "Nenhuma bebida selecionada";

        // Coleta a faixa de convidados
        int selectedGuestId = radioGroupGuests.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedGuestId);
        String guestRange = selectedRadioButton.getText().toString();

        // Cria a Intent para a tela de resumo
        Intent intent = new Intent(FormActivity.this, SummaryActivity.class);
        intent.putExtra("EVENT_NAME", eventName);
        intent.putExtra("LOCATION", location);
        intent.putExtra("DATE", date);
        intent.putExtra("EVENT_TYPE", eventType);
        intent.putExtra("FOODS", selectedFoods);
        intent.putExtra("DRINKS", selectedDrinks);
        intent.putExtra("GUESTS", guestRange);
        intent.putExtra("COMMENT", comment);

        startActivity(intent);
    }
}
