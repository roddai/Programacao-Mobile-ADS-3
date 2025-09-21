package com.example.aula7;

import android.os.Bundle;
import android.service.controls.actions.ModeAction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

     ImageView ImgCPU, Pedra, Papel, Tesoura, Resultado,ImagemJogador, Motaro, Patolino;
     TextView TextoResultado;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImgCPU = findViewById(R.id.ImgCPU);
        Pedra = findViewById(R.id.Pedra);
        Papel = findViewById(R.id.Papel);
        Tesoura = findViewById(R.id.Tesoura);
        Resultado = findViewById(R.id.ImgResultado);
        TextoResultado = findViewById(R.id.TextoResultado);
        ImagemJogador = findViewById(R.id.ImagemJogador);
        Motaro = findViewById(R.id.motaro);
        Patolino = findViewById(R.id.patolino);


        Motaro.setOnClickListener(v -> trocarIcone("1"));
        Patolino.setOnClickListener(v -> trocarIcone("2"));
        Pedra.setOnClickListener(v -> jogar("pedra"));
        Papel.setOnClickListener(v -> jogar("papel"));
        Tesoura.setOnClickListener(v -> jogar("tesoura"));


    }
        public void trocarIcone(String Icone){
            if(Icone.equals("1")){
                ImagemJogador.setImageResource(R.drawable.usuario_masc);
            }
            if(Icone.equals("2")){
                ImagemJogador.setImageResource(R.drawable.usuario_fem);
            }
        }



        public void jogar(String EscolhaUsuario) {
            String[] opções = { "pedra", "papel", "tesoura", "spinner"};
            int numero = new Random().nextInt(4);
            String escolhaCPU = opções[numero];
            switch (escolhaCPU) {
                case "pedra":
                    Resultado.setImageResource(R.drawable.pedra);
                    break;
                case "tesoura":
                    Resultado.setImageResource(R.drawable.tesoura);
                    break;
                case "papel":
                    Resultado.setImageResource(R.drawable.papel);
                    break;
                case "spinner":
                    Resultado.setImageResource(R.drawable.spinner);
            }
            if (EscolhaUsuario.equals(escolhaCPU)) {
                TextoResultado.setText("EMPATE");
            }
            else if (EscolhaUsuario.equals("pedra") && escolhaCPU.equals("tesoura") || EscolhaUsuario.equals("papel") && escolhaCPU.equals("pedra") || EscolhaUsuario.equals("tesoura") && escolhaCPU.equals("papel")){
                TextoResultado.setText("VOCÊ VENCEU O ZOIO BOLADO!");}
            else if (EscolhaUsuario.equals("pedra") && escolhaCPU.equals("papel") || EscolhaUsuario.equals("papel") && escolhaCPU.equals("tesoura") || EscolhaUsuario.equals("tesoura") && escolhaCPU.equals("pedra")) {
            }
            else if(escolhaCPU.equals("spinner")) {
                TextoResultado.setText("NÃO EXISTE ESCAPATÓRIA DO BAGUI QUE GIRA");
            }


        }
}