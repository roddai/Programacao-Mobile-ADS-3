package com.example.java_aula_mobile;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Pet pet = (Pet) getIntent().getSerializableExtra("pet");

        ImageView imgPet = findViewById(R.id.imgPet);
        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtCor = findViewById(R.id.txtCor);
        TextView txtRaca = findViewById(R.id.txtRaca);
        TextView txtIdade = findViewById(R.id.txtIdade);
        TextView txtAniversario = findViewById(R.id.txtAniversario);
        TextView txtSexo = findViewById(R.id.txtSexo);

        if (pet != null) {
            imgPet.setImageResource(pet.getImagemResId());
            txtNome.setText("Nome: " + pet.getNome());
            txtCor.setText("Cor: " + pet.getCor());
            txtRaca.setText("Raça: " + pet.getRaca());
            txtIdade.setText("Idade: " + pet.getIdade());
            txtAniversario.setText("Aniversário: " + pet.getAniversario());
            txtSexo.setText("Sexo: " + pet.getSexo());
        }
    }
}
