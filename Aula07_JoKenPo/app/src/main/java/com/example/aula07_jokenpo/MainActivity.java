package com.example.aula07_jokenpo;

import android.os.Bundle;
import  android.widget.ImageView;
import  android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgMaquina, imgPedra, imgPapel, imgTesoura;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMaquina = findViewById(R.id.imgMaquina);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);

        txtResultado = findViewById(R.id.txtResultado);

        imgPedra.setOnClickListener(v -> jogar("pedra"));
        imgPapel.setOnClickListener(v -> jogar("papel"));
        imgTesoura.setOnClickListener(v -> jogar("tesoura"));

    }
    public void jogar(String escolhaUsuario)
    {
        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);
        String escolhaMaquina = opcoes[numero];

        switch (escolhaMaquina)
        {
            case "pedra":
                imgMaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgMaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgMaquina.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaUsuario.equals(escolhaMaquina))
        {
            txtResultado.setText("Empate!");
        }
        else if (escolhaUsuario.equals("pedra") && escolhaMaquina.equals("tesoura") || escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("papel") || escolhaUsuario.equals("papel") && escolhaMaquina.equals("pedra"))
        {
            txtResultado.setText("Você venceu!");
        }
        else if (escolhaUsuario.equals("papel") && escolhaMaquina.equals("tesoura") || escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("pedra") || escolhaUsuario.equals("pedra") && escolhaMaquina.equals("papel"))
        {
            txtResultado.setText("Você perdeu!");
        }
        else
        {
            txtResultado.setText("Erro de lógica. Vai estudar, seu burro!");
        }
    }
}