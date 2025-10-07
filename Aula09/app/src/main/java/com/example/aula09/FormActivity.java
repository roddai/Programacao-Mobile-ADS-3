package com.example.aula09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Declarar os componentes
        EditText etNome = findViewById(R.id.edNomeEvento);
        EditText etData = findViewById(R.id.edDataEvento);
        Spinner spinnerLocal = findViewById(R.id.spinnerLocal);
        Spinner spinnerTipo = findViewById(R.id.spinnerTipo);
        CheckBox cbOpcao1 = findViewById(R.id.cbOpcao1);
        CheckBox cbOpcao2 = findViewById(R.id.cbOpcao2);
        CheckBox cbOpcao3 = findViewById(R.id.cbOpcao3);
        CheckBox cbOpcao4 = findViewById(R.id.cbOpcao4);
        CheckBox cbOpcaoB1 = findViewById(R.id.cbOpcaoB1);
        CheckBox cbOpcaoB2 = findViewById(R.id.cbOpcaoB2);
        CheckBox cbOpcaoB3 = findViewById(R.id.cbOpcaoB3);
        CheckBox cbOpcaoB4 = findViewById(R.id.cbOpcaoB4);
        RadioButton rbS50p = findViewById(R.id.rb50p);
        RadioButton rb51a100p = findViewById(R.id.rb51a100p);
        RadioButton rbS101p = findViewById(R.id.rb101);
        RadioGroup rgPessoas = findViewById(R.id.rgPessoas);
        EditText etComentarios = findViewById(R.id.edComentario);
        Button btnProxima = findViewById(R.id.BntProxima);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        // Arrays para os Spinners
        String[] Local = {"São Paulo", "Rio de Janeiro", "Porto Alegre"};
        String[] Tipo = {"Aniversário", "Casamento", "Corporativo"};

        // Configurar o ArrayAdapter para o Spinner de Local
        ArrayAdapter<String> adapterLocal = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Local);
        adapterLocal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocal.setAdapter(adapterLocal);

        // Configurar o ArrayAdapter para o Spinner de Tipo
        ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Tipo);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapterTipo);

        // Configuração do botão "Próxima"
        btnProxima.setOnClickListener(v -> {
            // Obter dados dos campos
            String Nome = etNome.getText().toString();
            String Data = etData.getText().toString();
            String Comentarios = etComentarios.getText().toString();

            // Coletar as opções marcadas
            String opcoes = "";
            if (cbOpcao1.isChecked()) opcoes += "Salgado ";
            if (cbOpcao2.isChecked()) opcoes += "Churrasco ";
            if (cbOpcao3.isChecked()) opcoes += "Doces";
            if (cbOpcao4.isChecked()) opcoes += "Nenhuma ";
            if (cbOpcaoB1.isChecked()) opcoes += "Refrigerante ";
            if (cbOpcaoB2.isChecked()) opcoes += "Cervejas";
            if (cbOpcaoB3.isChecked()) opcoes += "Vodkas";
            if (cbOpcaoB4.isChecked()) opcoes += "Nenhuma ";

            // Coletar a seleção de pessoas
            String simNao;
            if (rbS50p.isChecked()) {
                simNao = "50 Pessoas";
            } else if (rb51a100p.isChecked()) {
                simNao = "De 51 a 100 Pessoas";
            } else {
                simNao = "Mais de 100 Pessoas";
            }

            // Obter a escolha do local e tipo
            String LocalSelecionada = spinnerLocal.getSelectedItem().toString();
            String TipoSelecionada = spinnerTipo.getSelectedItem().toString();

            // Criar o resultado para enviar à próxima tela
            String resultado = "Nome: " + Nome +
                    "\nData: " + Data +
                    "\nOpções marcadas: " + opcoes +
                    "\nEscolha de pessoas: " + simNao +
                    "\nLocal escolhido: " + LocalSelecionada +
                    "\nTipo de evento: " + TipoSelecionada +
                    "\nComentários: " + Comentarios;

            // Enviar os dados para a SummaryActivity
            Intent intent = new Intent(FormActivity.this, SummaryActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);
        });

        // Configuração do botão "Voltar" (opcional, caso queira adicionar funcionalidade)
        btnVoltar.setOnClickListener(v -> {
            // Ação para voltar para a tela anterior (se necessário)
            finish(); // Isso encerra a activity atual e volta para a anterior
        });
    }
}
