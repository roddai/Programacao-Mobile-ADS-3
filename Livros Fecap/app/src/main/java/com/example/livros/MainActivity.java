package com.example.euprovavelmentenaodeviacolocaronometaograndemaseuireitestarolimitedecaracteresqueonome;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Livro livro1, livro2, livro3;
    TextView textInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInfo = findViewById(R.id.textInfo);

        /* Declarando os livros*/
        livro1 = new Livro("Ser mais poderoso do universo.png", "O Proprio Thanos", 2025);
        livro2 = new Livro("Vida de artista", "Lula Molusco", 2502);
        livro3 = new Livro("Coisa mais linda não à", "Shreka", 2025);

        /* Declarando os botões*/
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        /* dando funções aos botões*/
        button1.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
        button2.setOnClickListener(v -> textInfo.setText(livro2.getInfo()));
        button3.setOnClickListener(v -> textInfo.setText(livro3.getInfo()));




    }




}