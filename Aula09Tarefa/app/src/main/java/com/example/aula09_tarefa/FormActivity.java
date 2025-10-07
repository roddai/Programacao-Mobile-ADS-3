package com.example.aula09_tarefa;



import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aula09_tarefa.R;

public class FormActivity extends AppCompatActivity {

    EditText etNomeEvento, etDataEvento, etComentario;
    Spinner spLocal, spTipo;
    CheckBox cbSalgados, cbDoces, cbChurrasco, cbNenhumaComida;
    CheckBox cbRefri, cbCerveja, cbVodka, cbNenhumaBebida;
    RadioGroup rgConvidados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Referências
        etNomeEvento = findViewById(R.id.etNomeEvento);
        etDataEvento = findViewById(R.id.etDataEvento);
        etComentario = findViewById(R.id.etComentario);
        spLocal = findViewById(R.id.spLocal);
        spTipo = findViewById(R.id.spTipo);
        cbSalgados = findViewById(R.id.cbSalgados);
        cbDoces = findViewById(R.id.cbDoces);
        cbChurrasco = findViewById(R.id.cbChurrasco);
        cbNenhumaComida = findViewById(R.id.cbNenhumaComida);
        cbRefri = findViewById(R.id.cbRefri);
        cbCerveja = findViewById(R.id.cbCerveja);
        cbVodka = findViewById(R.id.cbVodka);
        cbNenhumaBebida = findViewById(R.id.cbNenhumaBebida);
        rgConvidados = findViewById(R.id.rgConvidados);
        Button btnProximo = findViewById(R.id.btnProximo);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        // Spinners
        String[] locais = {"São Paulo", "Rio de Janeiro", "Porto Alegre", "Curitiba", "Salvador"};
        String[] tipos = {"Aniversário", "Casamento", "Corporativo", "Outro"};

        spLocal.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locais));
        spTipo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos));

        btnProximo.setOnClickListener(v -> {
            String nome = etNomeEvento.getText().toString();
            String data = etDataEvento.getText().toString();
            String local = spLocal.getSelectedItem().toString();
            String tipo = spTipo.getSelectedItem().toString();
            String comentario = etComentario.getText().toString();

            String comidas = "";
            if (cbSalgados.isChecked()) comidas += "Salgados ";
            if (cbDoces.isChecked()) comidas += "Doces ";
            if (cbChurrasco.isChecked()) comidas += "Churrasco ";
            if (cbNenhumaComida.isChecked()) comidas += "Nenhuma ";

            String bebidas = "";
            if (cbRefri.isChecked()) bebidas += "Refrigerantes ";
            if (cbCerveja.isChecked()) bebidas += "Cervejas ";
            if (cbVodka.isChecked()) bebidas += "Vodkas ";
            if (cbNenhumaBebida.isChecked()) bebidas += "Nenhuma ";

            int idRadio = rgConvidados.getCheckedRadioButtonId();
            RadioButton rbSelecionado = findViewById(idRadio);
            String convidados = (rbSelecionado != null) ? rbSelecionado.getText().toString() : "N/A";

            Intent intent = new Intent(FormActivity.this, SummaryActivity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("data", data);
            intent.putExtra("local", local);
            intent.putExtra("tipo", tipo);
            intent.putExtra("comidas", comidas);
            intent.putExtra("bebidas", bebidas);
            intent.putExtra("convidados", convidados);
            intent.putExtra("comentario", comentario);
            startActivity(intent);
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
