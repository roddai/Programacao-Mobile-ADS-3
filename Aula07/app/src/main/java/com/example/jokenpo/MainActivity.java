package com.example.jokenpo;

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

    ImageView imgMaquina, imgPedra, imgPapel, imgTesoura, imgPersonagemFeminino, imgPersonagemMasculino, imgEscolhaMaquina, imgEscolhaUsuario, imgPersonagemUsuario;;
    TextView txtResultado;

    String personagemEscolhido = "feminino";  // valor padrão

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imgMaquina = findViewById(R.id.imgMaquina);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);

        txtResultado = findViewById(R.id.txtResultado);

        imgPedra.setOnClickListener(v -> jogar("pedra"));
        imgPapel.setOnClickListener(v -> jogar("papel"));
        imgTesoura.setOnClickListener(v -> jogar("tesoura"));


        imgEscolhaMaquina = findViewById(R.id.imgEscolhaMaquina);
        imgEscolhaUsuario = findViewById(R.id.imgEscolhaUsuario);
        imgPersonagemUsuario = findViewById(R.id.imgPersonagemUsuario);
        imgPersonagemFeminino = findViewById(R.id.imgPersonagemFeminino);
        imgPersonagemMasculino = findViewById(R.id.imgPersonagemMasculino);

        // Inicializa personagem padrão
        imgPersonagemUsuario.setImageResource(R.drawable.usuario_fem);

        imgPersonagemFeminino.setOnClickListener(v -> {
            personagemEscolhido = "feminino";
            imgPersonagemUsuario.setImageResource(R.drawable.usuario_fem);
        });

        imgPersonagemMasculino.setOnClickListener(v -> {
            personagemEscolhido = "masculino";
            imgPersonagemUsuario.setImageResource(R.drawable.usuario_masc);
        });
    }

    public void jogar(String escolhaUsuario) {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaMaquina = opcoes[numero];

        // Atualiza imagem da escolha da máquina
        switch (escolhaMaquina) {
            case "pedra":
                imgEscolhaMaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgEscolhaMaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgEscolhaMaquina.setImageResource(R.drawable.tesoura);
                break;
        }

        // Atualiza imagem da escolha do usuário
        switch (escolhaUsuario) {
            case "pedra":
                imgEscolhaUsuario.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgEscolhaUsuario.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgEscolhaUsuario.setImageResource(R.drawable.tesoura);
                break;
        }

        // A lógica do resultado continua a mesma
        if (escolhaUsuario.equals(escolhaMaquina)) {
            txtResultado.setText("Empate!");
        } else if (
                (escolhaUsuario.equals("pedra") && escolhaMaquina.equals("tesoura")) ||
                        (escolhaUsuario.equals("papel") && escolhaMaquina.equals("pedra")) ||
                        (escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("papel"))
        ) {
            txtResultado.setText("Você ganhou!");
        } else {
            txtResultado.setText("Você perdeu!");
        }
    }


}