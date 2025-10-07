package com.example.aula09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnProximo = findViewById(R.id.BntProxima);
        btnProximo.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this,FormActivity.class);
            startActivity(intent);
        });
    }
}