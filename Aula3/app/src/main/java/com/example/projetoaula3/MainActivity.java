package com.example.projetoaula3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Livro livro1, livro2, livro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textInfo;
        textInfo = findViewById(R.id.textView2);

        livro1 = new Livro("Programando o Android", "Zigurd Mednieks", 2012);
        livro2 = new Livro("Título do Livro 2", "Autor do Livro 2", 2025);
        livro3 = new Livro("Título do Livro 3", "Autor do Livro 3", 2025);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
        button2.setOnClickListener(v -> textInfo.setText(livro2.getInfo()));
        button3.setOnClickListener(v -> textInfo.setText(livro3.getInfo()));
    }
}