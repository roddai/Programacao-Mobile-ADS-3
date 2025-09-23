package com.example.ni1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    private Button a1,b1,c1,a2,b2b,c2,a3,b3,c3,enviar;


    private int contA = 0;
    private int contB = 0;
    private int contC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        a1 = findViewById(R.id.a1);
        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        a2 = findViewById(R.id.a2);
        b2b = findViewById(R.id.b2b);
        c2 = findViewById(R.id.c2);
        a3 = findViewById(R.id.a3);
        b3 = findViewById(R.id.b3);
        c3 = findViewById(R.id.c3);
        enviar = findViewById(R.id.enviar);

        a1.setOnClickListener(v -> Resposta("a"));
        a2.setOnClickListener(v -> Resposta("a"));
        a3.setOnClickListener(v -> Resposta("a"));
        b1.setOnClickListener(v -> Resposta("b"));
        b2b.setOnClickListener(v -> Resposta("b"));
        b3.setOnClickListener(v -> Resposta("b"));
        c1.setOnClickListener(v -> Resposta("c"));
        c2.setOnClickListener(v -> Resposta("c"));
        c3.setOnClickListener(v -> Resposta("c"));

        enviar.setOnClickListener(v -> {
            Intent resultado = new Intent(QuizActivity.this, ResultadoActivity.class);
            String result;

            if (contA > contB && contA > contC) {
                result= "Você é uma pessoa aberta, extrovertida e organizada";
            } else if (contB > contA && contB > contC) {
                result= "Você é uma pessoa adaptável e moderada";
            } else if (contC > contA && contC > contB) {
                result = "Você é uma pessoa introspectiva, rígida ou espontânea";
            } else {
                result= "Resultado inconclusivo";
            }

            resultado.putExtra("resultado", result);

            startActivity(resultado);
        });
    }
    public void Resposta(String alternativa) {

        switch (alternativa) {
            case "a":
                contA+=1;
                break;
            case "b":
                contB+=1;
                break;
            case "c":
                contC+=1;
                break;
        }
    }

}
