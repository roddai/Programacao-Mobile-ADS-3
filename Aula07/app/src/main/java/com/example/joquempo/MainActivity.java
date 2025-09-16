package com.example.joquempo;

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

    ImageView imgmaquina, imgpedra,imgtesoura,imgpapel;
    TextView txtresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgmaquina = findViewById(R.id.imgmaquina);
        imgpedra = findViewById(R.id.imgpedra);
        imgpapel = findViewById(R.id.imgpapel);
        imgtesoura = findViewById(R.id.imgtesoura);

        txtresultado = findViewById(R.id.txtresultado);



        imgpedra.setOnClickListener(v -> jogar("pedra"));
        imgpapel.setOnClickListener(v -> jogar("papel"));
        imgtesoura.setOnClickListener(v -> jogar("tesoura"));

        };
        public void jogar(String escolhausuario) {
            String[] opcoes ={"pedra","papel","tesoura"};
            int numero = new Random().nextInt(3);
            String escolhaMaquina = opcoes[numero];

            switch (escolhaMaquina){
                case "pedra":
                    imgmaquina.setImageResource(R.drawable.pedra);
                    break;
                case "papel":
                    imgmaquina.setImageResource(R.drawable.papel);
                    break;
                case "tesoura":
                    imgmaquina.setImageResource(R.drawable.tesoura);
                    break;
            }

            if (escolhausuario.equals(escolhaMaquina)){
                txtresultado.setText("Empate!");
            }else if ((escolhausuario.equals("pedra") && escolhaMaquina.equals("tesoura"))
                || (escolhausuario.equals("papel") && escolhaMaquina.equals("pedra"))
                    ||(escolhausuario.equals("tesoura") && escolhaMaquina.equals("papel"))){
                txtresultado.setText("Você ganhou");
            } else{
                txtresultado.setText("Você perdeu");
            }
        }

    }
