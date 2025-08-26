package com.example.euodeiojavaaaa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Livro livro1, livro2, livro3;
    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        livro1 = new Livro("A História de Chu Passeios", "Chu Passeios", 1400);
        livro2 = new Livro("A História de Chu Papitos", "Chu Papitos", 1397);
        livro3 = new Livro("Levar ferro até em Tupi ou madeira até em Joá?", "Chu Palbo Ha", 1500);

        textInfo = findViewById(R.id.textView);
        Button botaAQUI = findViewById(R.id.button);

        botaAQUI.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
    }
}