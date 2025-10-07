package com.example.aula9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        EditText etNome = findViewById(R.id.etNome);
        Spinner spinnerLocais = findViewById(R.id.spinnerLocais);
        EditText etData = findViewById(R.id.etData);
        Spinner spinnerTipo = findViewById(R.id.spinnerTipo);
        CheckBox cbOpcao1 = findViewById(R.id.cbOpcao1);
        CheckBox cbOpcao2 = findViewById(R.id.cbOpcao2);
        CheckBox cbOpcao3 = findViewById(R.id.cbOpcao3);
        CheckBox cbOpcao4 = findViewById(R.id.cbOpcao4);
        CheckBox cbOpcao5 = findViewById(R.id.cbOpcao5);
        CheckBox cbOpcao6 = findViewById(R.id.cbOpcao6);
        CheckBox cbOpcao7 = findViewById(R.id.cbOpcao7);
        CheckBox cbOpcao8 = findViewById(R.id.cbOpcao8);
        RadioButton pouca = findViewById(R.id.pouca);
        RadioButton maisoumenos = findViewById(R.id.maisoumenos);
        RadioButton muita = findViewById(R.id.muita);
        RadioGroup rgSimNao = findViewById(R.id.rgSimNao);
        EditText etComentario = findViewById(R.id.etComentario);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        Button voltar = findViewById(R.id.voltar);

        String[] locais = {"São Paulo", "Rio de Janeiro", "Porto Alegre", "Goiais", "Bauneário Camburiú"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locais);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocais.setAdapter(adapter);

        String[] tipo = {"Aniversário", "Casamento", "Corporativo", "Outro"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapter2);

        voltar.setOnClickListener(v -> finish());

        btnEnviar.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            String data = etData.getText().toString();

            String opcaoComida = "";
            String opcaoBebida = "";
            if (cbOpcao1.isChecked()) opcaoComida += "Salgados";
            if (cbOpcao2.isChecked()) opcaoComida += "Doces";
            if (cbOpcao3.isChecked()) opcaoComida += "Churrasco";
            if (cbOpcao4.isChecked()) opcaoComida += "Nenhuma";
            if (cbOpcao5.isChecked()) opcaoBebida += "Refrigerantes";
            if (cbOpcao6.isChecked()) opcaoBebida += "Cervejas";
            if (cbOpcao7.isChecked()) opcaoBebida += "Vodkas";
            if (cbOpcao8.isChecked()) opcaoBebida += "Nenhuma";

            String quantidade;

            if (pouca.isChecked()) {
                quantidade = "Até 50 pessoas";
            } else if (maisoumenos.isChecked()) {
                quantidade = "51 a 100 pessoas";
            } else if (muita.isChecked()) {
                quantidade = "Mais de 100 pessoas";
            } else {
                quantidade = "N/A";
            }

            String localSelecionado = spinnerLocais.getSelectedItem().toString();
            String tipoSelecionado = spinnerTipo.getSelectedItem().toString();
            String comentario = etComentario.getText().toString();

            String resultado = "Nome: " + nome +
                    "\nData: " + data +
                    "\nOpções de comida: " + opcaoComida +
                    "\nOpções de bebida: " + opcaoBebida +
                    "\nQuantidade de pessoas: " + quantidade +
                    "\nLocal escolhido: " + localSelecionado +
                    "\nTipo de evento: " + tipoSelecionado +
                    "\nComentario: " + comentario;

            Intent intent = new Intent(FormActivity.this, SummaryActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);
        });
    }
}