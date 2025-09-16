package com.example.jokenpo;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView maquina, pedra, papel, tesoura, muie, homi, homi2, interrogacao, interrogacao2;

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
        homi = findViewById(R.id.homi);
        homi2 = findViewById(R.id.homi2);
        muie = findViewById(R.id.muie);
        interrogacao = findViewById(R.id.interrogacao);
        interrogacao2 = findViewById(R.id.interrogacao2);

        Resultado = findViewById(R.id.Resultado);

        pedra.setOnClickListener(v -> jogar("pedra"));
        papel.setOnClickListener(v -> jogar("papel"));
        tesoura.setOnClickListener(v -> jogar("tesoura"));

        homi.setOnClickListener(v -> definirGenero("homi");
        muie.setOnClickListener(v -> definirGenero("muie");
    }
    public void definirGenero(String genero)
    {
        switch (genero) {
            case "homi":
                homi2.setImageResource(R.drawable.usuario_masc);
                break;
            case "muie":
                homi2.setImageResource(R.drawable.usuario_fem);
                break;
        }
    }

    public void jogar (String escolhaUser)
    {
        switch  (escolhaUser)
        {
            case "pedra":
                interrogacao2.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                interrogacao2.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                interrogacao2.setImageResource(R.drawable.tesoura);
                break;

        }
        String[] opcoes = {"pedra", "papel", "tesoura"};

        int num = new Random().nextInt(3);
        String escolhaMaquina = opcoes[num];

        switch (escolhaMaquina){
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
        if (escolhaUser.equals(escolhaMaquina))
        {
            Resultado.setText("Empate");
        }else if (escolhaUser.equals("pedra") && escolhaMaquina.equals("tesoura"))
        {
            interrogacao2.setImageResource(R.drawable.pedra);
            Resultado.setText("Você Ganhou!!");

        }else if (escolhaUser.equals("papel") && escolhaMaquina.equals("pedra"))
        {
            interrogacao2.setImageResource(R.drawable.tesoura);
            Resultado.setText("Você Ganhou!!");

        }else if (escolhaUser.equals("tesoura") && escolhaMaquina.equals("papel"))
        {
            interrogacao2.setImageResource(R.drawable.);
            Resultado.setText("Você Ganhou!!");

        }else
        {
            Resultado.setText("Você Perdeu!!");
        }
    }
}
}