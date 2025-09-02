package com.example.entregaprovan1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TelaResultado extends AppCompatActivity {
    TextView ResultadoFim;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        ResultadoFim = findViewById(R.id.ResultadoFinale);
        String Resultado = getIntent().getStringExtra("ResultadoFinal");
        ResultadoFim.setText(Resultado);

    }

}
