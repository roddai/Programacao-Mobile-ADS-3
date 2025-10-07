package com.example.eventosocial;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText etNomeEvento, etData, etComentario;
    private Spinner spLocal, spTipo;
    private CheckBox cbSalgados, cbDoces, cbChurrasco, cbComidaNenhuma;
    private CheckBox cbRefri, cbCerveja, cbVodka, cbBebidaNenhuma;
    private RadioGroup rgConvidados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Inputs
        etNomeEvento = findViewById(R.id.etNomeEvento);
        etData = findViewById(R.id.etData);
        etComentario = findViewById(R.id.etComentario);

        spLocal = findViewById(R.id.spLocal);
        spTipo = findViewById(R.id.spTipo);

        cbSalgados = findViewById(R.id.cbSalgados);
        cbDoces = findViewById(R.id.cbDoces);
        cbChurrasco = findViewById(R.id.cbChurrasco);
        cbComidaNenhuma = findViewById(R.id.cbComidaNenhuma);

        cbRefri = findViewById(R.id.cbRefri);
        cbCerveja = findViewById(R.id.cbCerveja);
        cbVodka = findViewById(R.id.cbVodka);
        cbBebidaNenhuma = findViewById(R.id.cbBebidaNenhuma);

        rgConvidados = findViewById(R.id.rgConvidados);

        // ---------------- CONFIGURAÇÃO DOS SPINNERS ----------------
        ArrayAdapter<CharSequence> locaisAdapter = ArrayAdapter.createFromResource(
                this, R.array.locais_array, android.R.layout.simple_spinner_item);
        locaisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLocal.setAdapter(locaisAdapter);

        ArrayAdapter<CharSequence> tiposAdapter = ArrayAdapter.createFromResource(
                this, R.array.tipos_array, android.R.layout.simple_spinner_item);
        tiposAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(tiposAdapter);
        // ------------------------------------------------------------

        // Lógica dos CheckBoxes "Nenhuma" (desmarca outros)
        cbComidaNenhuma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbSalgados.setChecked(false);
                cbDoces.setChecked(false);
                cbChurrasco.setChecked(false);
            }
        });
        cbBebidaNenhuma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbRefri.setChecked(false);
                cbCerveja.setChecked(false);
                cbVodka.setChecked(false);
            }
        });

        // Se marcar qualquer outro, desmarca “Nenhuma”
        CheckBox[] comidaBoxes = {cbSalgados, cbDoces, cbChurrasco};
        for (CheckBox cb : comidaBoxes) {
            cb.setOnCheckedChangeListener((b, isChecked) -> {
                if (isChecked) cbComidaNenhuma.setChecked(false);
            });
        }
        CheckBox[] bebidaBoxes = {cbRefri, cbCerveja, cbVodka};
        for (CheckBox cb : bebidaBoxes) {
            cb.setOnCheckedChangeListener((b, isChecked) -> {
                if (isChecked) cbBebidaNenhuma.setChecked(false);
            });
        }

        // Botões
        Button btnVoltar = findViewById(R.id.btnVoltarForm);
        Button btnProximo = findViewById(R.id.btnProximo);

        btnVoltar.setOnClickListener(v -> finish());

        btnProximo.setOnClickListener(v -> {
            if (!validar()) return;

            String nome = etNomeEvento.getText().toString().trim();
            String data = etData.getText().toString().trim();
            String local = spLocal.getSelectedItem().toString();
            String tipo = spTipo.getSelectedItem().toString();
            String comidas = montarSelecionados(
                    new String[]{"Salgados", "Doces", "Churrasco"},
                    new CheckBox[]{cbSalgados, cbDoces, cbChurrasco},
                    cbComidaNenhuma.isChecked()
            );
            String bebidas = montarSelecionados(
                    new String[]{"Refrigerantes", "Cervejas", "Vodkas"},
                    new CheckBox[]{cbRefri, cbCerveja, cbVodka},
                    cbBebidaNenhuma.isChecked()
            );

            String faixaConvidados = "";
            int checkedId = rgConvidados.getCheckedRadioButtonId();
            if (checkedId != -1) {
                RadioButton rb = findViewById(checkedId);
                faixaConvidados = rb.getText().toString();
            }

            String comentario = etComentario.getText().toString().trim();

            Intent i = new Intent(FormActivity.this, SummaryActivity.class);
            i.putExtra("nome", nome);
            i.putExtra("data", data);
            i.putExtra("local", local);
            i.putExtra("tipo", tipo);
            i.putExtra("comidas", comidas);
            i.putExtra("bebidas", bebidas);
            i.putExtra("convidados", faixaConvidados);
            i.putExtra("comentario", comentario);
            startActivity(i);
        });
    }

    // ---------------- VALIDAÇÃO ----------------
    private boolean validar() {
        if (TextUtils.isEmpty(etNomeEvento.getText())) {
            etNomeEvento.setError("Informe o nome do evento");
            etNomeEvento.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(etData.getText())) {
            etData.setError("Informe a data (ex: 10/11/2025)");
            etData.requestFocus();
            return false;
        }
        if (rgConvidados.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecione a faixa de convidados", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // ---------------- MONTAGEM DAS LISTAS DE SELECIONADOS ----------------
    private String montarSelecionados(String[] nomes, CheckBox[] boxes, boolean marcouNenhuma) {
        if (marcouNenhuma) return "Nenhuma";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isChecked()) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(nomes[i]);
            }
        }
        return sb.length() == 0 ? "Nenhuma" : sb.toString();
    }
}
