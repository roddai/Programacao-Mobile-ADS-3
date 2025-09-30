package com.example.aula8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        EditText etNome = findViewById(R.id.EditTextNome);
        EditText etIdade = findViewById(R.id.EditTextIdade);
        CheckBox cbOpcao1 = findViewById(R.id.checkBox);
        CheckBox cbOpcao2 = findViewById(R.id.checkBox2);
        RadioButton rbSim = findViewById(R.id.RbSim);
        RadioButton rbNao = findViewById(R.id.RbNao);
        RadioGroup rgSimNao = findViewById(R.id.radioGroup);
        Spinner spinnerCores = findViewById(R.id.Spinner1);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnEnviar = findViewById(R.id.button);

        String[] cores = {"Vermelho", "Azul", "Verde", "Amarelo", "Roxo", "Preto"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCores.setAdapter(adapter);

        btnEnviar.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            String idade = etIdade.getText().toString();

            String opcoes = "";
            if (cbOpcao1.isChecked()) opcoes += "Opção 1 ";
            if (cbOpcao2.isChecked()) opcoes += "Opção 2";

            String simNao;

            if (rbSim.isChecked()) {
                simNao = "Sim";
            } else if (rbNao.isChecked()) {
                simNao = "Não";
            } else {
                simNao = "N/A";
            }

            String corSelecionada = spinnerCores.getSelectedItem().toString();
            float avaliacao = ratingBar.getRating();

            String resultado = "Nome: " + nome +
                    "\nIdade: " + idade +
                    "\nOpções marcadas: " + opcoes +
                    "\nEscolha Sim/Não: " + simNao +
                    "\nCor escolhida: " + corSelecionada +
                    "\nAvaliação: " + avaliacao;

            Intent intent = new Intent(FormActivity.this, ResultadoActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);
        });
    }
}