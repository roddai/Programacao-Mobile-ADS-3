package com.example.aula06tarefa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPetActivity extends AppCompatActivity {

    TextView txtNome, txtCor, txtRaca, txtIdade, txtAniversario;
    ImageView imagePet;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        // Referência dos elementos da tela
        txtNome = findViewById(R.id.txtNome);
        txtCor = findViewById(R.id.txtCor);
        txtRaca = findViewById(R.id.txtRaca);
        txtIdade = findViewById(R.id.txtIdade);
        txtAniversario = findViewById(R.id.txtAniversario);
        imagePet = findViewById(R.id.imagePet);
        btnVoltar = findViewById(R.id.btnVoltar);


        // Recupera dados enviados pela intent
        Pet pet = getIntent().getParcelableExtra("pet");
        int imagemId = getIntent().getIntExtra("imagem", R.drawable.ic_launcher_foreground);

        if (pet != null) {
            txtNome.setText("Nome: " + pet.getNome());
            txtCor.setText("Cor: " + pet.getCor());
            txtRaca.setText("Raça: " + pet.getRaca());
            txtIdade.setText("Idade: " + pet.getIdade() + " anos");
            txtAniversario.setText("Aniversário: " + pet.getAniversario());
            imagePet.setImageResource(imagemId);
        }

        btnVoltar.setOnClickListener(v -> finish());
    }
}