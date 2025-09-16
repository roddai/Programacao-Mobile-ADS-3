package com.example.aula02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Livro livro1, livro2, livro3;

    TextView textInfo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    livro1 = new Livro("Desvendando a mente.", "Lucy Mari Tabuti", 2020);
    livro2 = new Livro("Manifesto Comunista.", "Karl Marx", 1848);
    livro3 = new Livro("Bobbie Goods", "Bob Gudi", 2023);

    textInfo = findViewById(R.id.textInfo);

    Button button = findViewById(R.id.button);
    Button button2 = findViewById(R.id.button2);
    Button button3 = findViewById(R.id.button3);

    button.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
    button2.setOnClickListener(v -> textInfo.setText(livro2.getInfo()));
    button3.setOnClickListener(v -> textInfo.setText(livro3.getInfo()));
    }
}

