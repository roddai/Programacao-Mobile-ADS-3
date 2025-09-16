package com.example.aula7exercicio;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView maquina, pedra, papel, tesoura;

    TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        maquina = findViewById(R.id.maquina);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);

        Resultado  = findViewById(R.id.Resultado);

        pedra.setOnClickListener(v -> jogar("pedra"));
        papel.setOnClickListener(v -> jogar("papel"));
        tesoura.setOnClickListener(v -> jogar("tesoura"));
    }

    public void jogar(String escolhaUsuario){
        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);

        String escolhaMaquina = opcoes[numero];

        switch (escolhaMaquina) {
            case "pedra":
                maquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                maquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                maquina.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaUsuario.equals(escolhaMaquina)){
            Resultado.setText("Empate!");
        } else if (escolhaUsuario.equals("pedra") && escolhaMaquina.equals("tesoura") ||
                escolhaUsuario.equals("papel") && escolhaMaquina.equals("pedra") ||
                escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("papel") )  {
            Resultado.setText("Você ganhou!");
        } else {
            Resultado.setText("Você perdeu!");
        }
    }
}