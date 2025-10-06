package com.example.quiz_inicio;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtResultado, txtDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtResultado.findViewById(R.id.txt_Resultado);
        txtDetalhe.findViewById(R.id.txt_Detalhe);

        int countA = getIntent().getIntExtra("countA", 0);
        int countB = getIntent().getIntExtra("countB", 0);
        int countC = getIntent().getIntExtra("countC", 0);

        String msg;

        int max = Math.max(countA, Math.max(countB, countC));
        int pontos = 0;
        if (countA == max) pontos++;
        if (countB == max) pontos++;
        if (countC == max) pontos++;

        if (pontos > 1){
            msg = "Sem resultado";
        }else {
            if (max == countA){
                msg = "Você é uma pessoa aberta, extrovertida e organizada";
            } else if (max == countB) {
                msg = "Você é uma pessoa adaptável e moderada";
            }else {
                msg = "Você é uma pessoa introspectiva, rígida ou espontânea";
            }
        }

        txtResultado.setText(msg);
        String detalhes = "Pontuação - a: " + countA + " | b: " + countB + "| c: " + countC;
        txtDetalhe.setText(detalhes);
    }
}
