package com.example.ni1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado); // conecta com activity_resultado.xml

        // Pegando o TextView que exibirá o resultado
        TextView txtResultado = findViewById(R.id.txtResultado);

        // Recebendo os pontos acumulados das outras telas
        int a = getIntent().getIntExtra("a", 0);
        int b = getIntent().getIntExtra("b", 0);
        int c = getIntent().getIntExtra("c", 0);

        // Variável para armazenar a mensagem final
        String mensagem;

        if (a > b && a > c) {
            mensagem = "Você é uma pessoa aberta, extrovertida e organizada.";
        } else if (b > a && b > c) {
            mensagem = "Você é uma pessoa adaptável e moderada.";
        } else if (c > a && c > b) {
            mensagem = "Você é uma pessoa introspectiva, rígida ou espontânea.";
        } else {
            mensagem = "Resultado inconclusivo.";
        }

        // Exibindo a mensagem no TextView
        txtResultado.setText(mensagem);
    }
}
