package com.example.pets;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pet);

        // Recuperar o pet da intent
        Pet pet = (Pet) getIntent().getSerializableExtra("PET");

        if (pet != null) {
            // Configurar os views
            ImageView imageViewPet = findViewById(R.id.imageViewPet);
            TextView textViewNome = findViewById(R.id.textViewNome);
            TextView textViewTipo = findViewById(R.id.textViewTipo);
            TextView textViewRaca = findViewById(R.id.textViewRaca);
            TextView textViewCor = findViewById(R.id.textViewCor);
            TextView textViewIdade = findViewById(R.id.textViewIdade);
            TextView textViewAniversario = findViewById(R.id.textViewAniversario);

            // Preencher os dados
            imageViewPet.setImageResource(pet.getImagemId());
            textViewNome.setText(pet.getNome());
            textViewTipo.setText("Tipo: " + pet.getTipo());
            textViewRaca.setText("Raça: " + pet.getRaca());
            textViewCor.setText("Cor: " + pet.getCor());
            textViewIdade.setText("Idade: " + pet.getIdade() + " anos");
            textViewAniversario.setText("Aniversário: " + pet.getAniversario());

            // Configurar título da activity
            setTitle("Detalhes do " + pet.getNome());
        }
    }
}