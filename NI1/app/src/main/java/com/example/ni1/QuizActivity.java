package com.example.ni1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private int pontosA = 0;
    private int pontosB = 0;
    private int pontosC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz); // garante que carrega o XML certo

        // Pegando os RadioButtons da segunda questão
        RadioButton rbQ2A = findViewById(R.id.rbQ2A);
        RadioButton rbQ2B = findViewById(R.id.rbQ2B);
        RadioButton rbQ2C = findViewById(R.id.rbQ2C);

        // Botão correto de acordo com o XML
        Button btnFinalizar = findViewById(R.id.submitBTN2);

        // Clique do botão
        btnFinalizar.setOnClickListener(v -> {
            if (rbQ2A.isChecked()) pontosA++;
            if (rbQ2B.isChecked()) pontosB++;
            if (rbQ2C.isChecked()) pontosC++;

            // Envia os pontos para a tela de Resultado
            Intent intent = new Intent(QuizActivity.this, ResultadoActivity.class);
            intent.putExtra("pontosA", pontosA);
            intent.putExtra("pontosB", pontosB);
            intent.putExtra("pontosC", pontosC);
            startActivity(intent);
        });
    }
}

