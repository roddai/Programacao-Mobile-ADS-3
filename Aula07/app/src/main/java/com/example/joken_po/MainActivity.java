package com.example.joken_po;

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


   ImageView imgMaquina, imgPedra, imgPapel, imgTesoura;

   TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgPapel = findViewById(R.id.imagePapel);
        imgPedra = findViewById(R.id.imagePedra);
        imgTesoura = findViewById(R.id.imageTesoura);
        imgMaquina = findViewById(R.id.imageMaquina);

        txtResultado = findViewById(R.id.txtResultado);

    imgPedra.setOnClickListener(v -> jogar("pedra"));
    imgPapel.setOnClickListener(v -> jogar("papel"));
    imgTesoura.setOnClickListener(v -> jogar("tesoura"));

    }

    public void jogar(String escolhaUsuario){
    String[] opcoes = {"pedra", "papel", "tesoura"};
    int numero = new Random().nextInt(3);
    String escolhaMaquina = opcoes[numero];

    switch (escolhaMaquina){
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

    if (escolhaUsuario.equals(escolhaMaquina)) {
        txtResultado.setText("Empate");}
       else if ((escolhaUsuario.equals("pedra") && escolhaMaquina.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaMaquina.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("papel"))) {
            txtResultado.setText("Você ganhou");}
        else{
            txtResultado.setText("Você perdeu");
        }
    }
}