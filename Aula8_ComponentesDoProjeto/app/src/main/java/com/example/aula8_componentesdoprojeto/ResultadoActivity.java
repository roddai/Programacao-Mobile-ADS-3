package com.example.aula8_componentesdoprojeto;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView dados = findViewById(R.id.TvDados);
        Button voltar = findViewById(R.id.BtnVoltar);

        String resultado = getIntent().getStringExtra("resultado");
        dados.setText(resultado);

        voltar.setOnClickListener(v -> finish());

    };
}
