package com.example.quiz_inicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    Button bt_1_a, bt_1_b, bt_1_c, bt_2_a, bt_2_b, bt_2_c, bt_3_a, bt_3_b, bt_3_c, bt_resultado;

    int countA = 0, countB = 0, countC = 0;
    boolean perg1 = false, perg2 = false, perg3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        bt_1_a = findViewById(R.id.bt_1_a);
        bt_1_b = findViewById(R.id.bt_1_b);
        bt_1_c = findViewById(R.id.bt_1_c);

        bt_2_a = findViewById(R.id.bt_2_a);
        bt_2_b = findViewById(R.id.bt_2_b);
        bt_2_c = findViewById(R.id.bt_2_c);

        bt_3_a = findViewById(R.id.bt_3_a);
        bt_3_b = findViewById(R.id.bt_3_b);
        bt_3_c = findViewById(R.id.bt_3_c);

        bt_resultado = findViewById(R.id.bt_resultado);


        bt_1_a.setOnClickListener(v -> {countA++; perg1 = true; bloqPergunta(1);});
        bt_1_b.setOnClickListener(v -> {countB++; perg1 = true; bloqPergunta(1);});
        bt_1_c.setOnClickListener(v -> {countC++; perg1 = true; bloqPergunta(1);});

        bt_2_a.setOnClickListener(v -> {countA++; perg2 = true; bloqPergunta(2);});
        bt_2_b.setOnClickListener(v -> {countB++; perg2 = true; bloqPergunta(2);});
        bt_2_c.setOnClickListener(v -> {countC++; perg2 = true; bloqPergunta(2);});

        bt_3_a.setOnClickListener(v -> {countA++; perg3 = true; bloqPergunta(3);});
        bt_3_b.setOnClickListener(v -> {countB++; perg3 = true; bloqPergunta(3);});
        bt_3_c.setOnClickListener(v -> {countC++; perg3 = true; bloqPergunta(3);});

        bt_resultado.setOnClickListener(v ->{
            if (!perg1 || !perg2 || perg3){
                Toast.makeText(this, "Selecione a resposta!", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(QuizActivity.this, ResultadoActivity.class);
                intent.putExtra("countA", countA);
                intent.putExtra("countB", countB);
                intent.putExtra("countC", countC);
                startActivity(intent);
            }
        });

    }

    private void bloqPergunta(int pergunta){
        switch (pergunta){
            case 1:
                bt_1_a.setEnabled(false);
                bt_1_b.setEnabled(false);
                bt_1_c.setEnabled(false);
                break;
            case 2:
                bt_2_a.setEnabled(false);
                bt_2_b.setEnabled(false);
                bt_2_c.setEnabled(false);
                break;
            case 3:
                bt_3_a.setEnabled(false);
                bt_3_b.setEnabled(false);
                bt_3_c.setEnabled(false);
                break;
        }
    }

}
