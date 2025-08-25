package com.example.projectaula3;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Livro livro1, livro2, livro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    livro1 = new Livro("Programando o Android", "Zigurd Mednieks", 2012);
    livro2 = new Livro("Programando o Android", "Rick Rogers", 2014);
    livro3 = new Livro("Programando o Android", "Zigurd Mednieks", 2015);

    textInfo = findViewById(R.id.textinfo);

    Button button1 = findViewById(R.id.button);
    Button button2 = findViewById(R.id.button2);
    Button button3 = findViewById(R.id.button3);

    button1.setOnClickListener(v ->);
}