package com.example.aula06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout da primeira tela

        editNome = findViewById(R.id.editNome);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();

                Intent irParaSegundaTela = new Intent(MainActivity.this, PetActivity.class);
                irParaSegundaTela.putExtra("nome", nome);
                startActivity(irParaSegundaTela);
            }
        });
    }
}