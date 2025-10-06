package com.example.ni1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // conecta com activity_main.xml

        // Pegando os objetos da tela
        RadioButton rbQ1A = findViewById(R.id.rbQ1A);
        RadioButton rbQ1B = findViewById(R.id.rbQ1B);
        RadioButton rbQ1C = findViewById(R.id.rbQ1C);
        Button btn1 = findViewById(R.id.SubmitBTN);

        // Ação do botão
        btn1.setOnClickListener(v -> {
            int pontosA = 0, pontosB = 0, pontosC = 0;

            // Verifica qual resposta foi marcada
            if (rbQ1A.isChecked()) pontosA++;
            if (rbQ1B.isChecked()) pontosB++;
            if (rbQ1C.isChecked()) pontosC++;

            // Envia os pontos para a próxima tela (QuizActivity)
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("a", pontosA);
            intent.putExtra("b", pontosB);
            intent.putExtra("c", pontosC);
            startActivity(intent);
        });
    }
}
