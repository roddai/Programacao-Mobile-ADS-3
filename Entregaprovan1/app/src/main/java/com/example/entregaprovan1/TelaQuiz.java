package com.example.entregaprovan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TelaQuiz extends AppCompatActivity {

    EditText respostaquiz1, respostaquiz2, respostaquiz3;
    Button BotaoConfirmar;
    String resposta1, resposta2, resposta3;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaquiz);

        respostaquiz1 = findViewById(R.id.Resposta1);
        respostaquiz2 = findViewById(R.id.Resposta2);
        respostaquiz3 = findViewById(R.id.Resposta3);
        BotaoConfirmar = findViewById(R.id.BotaoResultado);

        BotaoConfirmar.setOnClickListener(v -> EnviarRespostas(resposta1, resposta2, resposta3));

    }


    protected void EnviarRespostas(String Resposta1, String Resposta2, String Resposta3){
        int As =0;
        int Bs =0;
        int Cs =0;
        String ResultadoFinal;
        Intent intent = new Intent(TelaQuiz.this, TelaResultado.class );


        resposta1 = respostaquiz1.getText().toString();
        resposta2 = respostaquiz2.getText().toString();
        resposta3 = respostaquiz3.getText().toString();

        if (resposta1.equals("a")) As++; // Textão em professor >:(
        if (resposta1.equals("b")) Bs++;
        if (resposta1.equals("c")) Cs++;

        if (resposta2.equals("a")) As++;
        if (resposta2.equals("b")) Bs++;
        if (resposta2.equals("c")) Cs++;

        if (resposta2.equals("a")) As++;
        if (resposta2.equals("b")) Bs++;
        if (resposta2.equals("c")) Cs++;

        if (As > Bs && As > Cs) {
            ResultadoFinal = "Você é uma pessoa aberta, extrovertida e organizada.";
        } else if (Bs > As && Bs > Cs) {
            ResultadoFinal = "Você é uma pessoa adaptável e moderada.";
        } else if (Cs > As && Cs > Bs) {
            ResultadoFinal = "Você é uma pessoa introspectiva, rígida ou espontânea.";
        } else {
            ResultadoFinal = "Resultado inconclusivo!! Por Favor Corrija suas respostas!";
        }

        intent.putExtra("ResultadoFinal", ResultadoFinal);
        startActivity(intent);
    }


}
