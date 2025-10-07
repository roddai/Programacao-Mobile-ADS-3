package com.example.eventosocial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvNome = findViewById(R.id.tvResumoNome);
        TextView tvLocal = findViewById(R.id.tvResumoLocal);
        TextView tvData = findViewById(R.id.tvResumoData);
        TextView tvTipo = findViewById(R.id.tvResumoTipo);
        TextView tvComidas = findViewById(R.id.tvResumoComidas);
        TextView tvBebidas = findViewById(R.id.tvResumoBebidas);
        TextView tvConvidados = findViewById(R.id.tvResumoConvidados);
        TextView tvComentario = findViewById(R.id.tvResumoComentario);

        // Recupera extras
        if (getIntent() != null) {
            tvNome.setText(getIntent().getStringExtra("nome"));
            tvLocal.setText(getIntent().getStringExtra("local"));
            tvData.setText(getIntent().getStringExtra("data"));
            tvTipo.setText(getIntent().getStringExtra("tipo"));
            tvComidas.setText(getIntent().getStringExtra("comidas"));
            tvBebidas.setText(getIntent().getStringExtra("bebidas"));
            tvConvidados.setText(getIntent().getStringExtra("convidados"));
            tvComentario.setText(getIntent().getStringExtra("comentario"));
        }

        Button btnVoltar = findViewById(R.id.btnVoltarResumo);
        btnVoltar.setOnClickListener(v -> finish()); // volta para edição (FormActivity)
    }
}
