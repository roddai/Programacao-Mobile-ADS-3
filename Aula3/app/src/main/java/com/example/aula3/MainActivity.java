

package com.example.aula3;

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


        livro1 = new

                Livro("Suiciadas", "Raphael Montes", 2022);

        livro2 = new

                Livro("Jantar secreto", "Raphael Montes", 2009);

        livro3 = new

                Livro("Dias Perfeitos", "Raphael Montes", 2025);

        textInfo =

                findViewById(R.id.textinfo);

        Button button1 = findViewById(R.id.button);

        Button button2 = findViewById(R.id.button2);

        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> textInfo.setText(livro1.getInfo()));
        button2.setOnClickListener(v -> textInfo.setText(livro2.getInfo()));
        button3.setOnClickListener(v -> textInfo.setText(livro3.getInfo()));
    }
}

