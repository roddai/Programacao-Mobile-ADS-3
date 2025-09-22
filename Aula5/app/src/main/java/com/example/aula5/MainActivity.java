package com.example.aula5;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Instanciando os livros */
        Livro livro1 = new Livro("Desenvolvendo seu Primeiro Aplicativo Android", "Luiz Carlos Querino Filho", 2017);
        Livro livro2 = new Livro("Programação de Jogos Android", "Edgard B. Damiani", 2016);
        Livro livro3 = new Livro("Desenvolvimento de Aplicativos. Um Guia Prático Para Criar Aplicativos com Ionic", "Erik Ieger Dobrychtop", 2018);

        TextView textInfo = findViewById(R.id.textInfo);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
        button2.setOnClickListener(v -> textInfo.setText(livro2.getInfo()));
        button3.setOnClickListener(v -> textInfo.setText(livro3.getInfo()));
    }
}
