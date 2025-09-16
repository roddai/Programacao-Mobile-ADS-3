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

    ImageView escolhamaquina, pedra, papel, tesoura, escolhausuario, fotoperfil, mulher, homem;

    TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        escolhamaquina = findViewById(R.id.escolhamaquina);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        escolhausuario = findViewById(R.id.escolhausuario);
        fotoperfil = findViewById(R.id.fotoperfil);
        mulher = findViewById(R.id.mulher);
        homem = findViewById(R.id.homem);

        Resultado  = findViewById(R.id.Resultado);

        pedra.setOnClickListener(v -> jogar("pedra"));
        papel.setOnClickListener(v -> jogar("papel"));
        tesoura.setOnClickListener(v -> jogar("tesoura"));

        mulher.setOnClickListener(v -> definirPerfil("mulher"));
        homem.setOnClickListener(v -> definirPerfil("homem"));
    }

    public void definirPerfil (String genero){

        switch (genero){
            case "homem":
                fotoperfil.setImageResource(R.drawable.usuario_masc);
                break;
            case "mulher":
                fotoperfil.setImageResource(R.drawable.usuario_fem);
                break;
        }
    }

    public void jogar(String escolhaUsuario){

        switch(escolhaUsuario){
            case "pedra":
                escolhausuario.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                escolhausuario.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                escolhausuario.setImageResource(R.drawable.tesoura);
                break;
        }

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);

        String escolhaMaquina = opcoes[numero];

        switch (escolhaMaquina) {
            case "pedra":
                escolhamaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                escolhamaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                escolhamaquina.setImageResource(R.drawable.tesoura);
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