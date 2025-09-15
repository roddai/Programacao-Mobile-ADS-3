package com.example.aula6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Instanciando os pets
    Pet cao1, cao2, cao3, gato1, gato2, gato3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando os objetos Pet
        cao1 = new Pet("Rex", "Branco", "Labrador", 5, "15 de março");
        cao2 = new Pet("Thor", "Preto e branco", "Sem raça definida", 2, "29 de julho");
        cao3 = new Pet("Luna", "Cinza", "German Sheferd", 1, "10 de maio");

        gato1 = new Pet("Mia", "Branco", "Persa", 3, "12 de novembro");
        gato2 = new Pet("Nina", "Preto", "Siamês", 1, "20 de agosto");
        gato3 = new Pet("Tom", "Laranja", "Sem raça definida", 6, "01 de janeiro");

        Button buttonCaes1 = findViewById(R.id.buttonCaes1);
        Button buttonCaes2 = findViewById(R.id.buttonCaes2);
        Button buttonCaes3 = findViewById(R.id.buttonCaes3);
        Button buttonGatos1 = findViewById(R.id.buttonGatos1);
        Button buttonGatos2 = findViewById(R.id.buttonGatos2);
        Button buttonGatos3 = findViewById(R.id.buttonGatos3);

        buttonCaes1.setOnClickListener(v -> abrirDetalhes(cao1, R.drawable.pet1));
        buttonCaes2.setOnClickListener(v -> abrirDetalhes(cao2, R.drawable.pet2));
        buttonCaes3.setOnClickListener(v -> abrirDetalhes(cao3, R.drawable.pet3));

        buttonGatos1.setOnClickListener(v -> abrirDetalhes(gato1, R.drawable.pet4));
        buttonGatos2.setOnClickListener(v -> abrirDetalhes(gato2, R.drawable.pet5));
        buttonGatos3.setOnClickListener(v -> abrirDetalhes(gato3, R.drawable.pet6));
    }

    private void abrirDetalhes(Pet pet, int drawableId) {
        Intent intent = new Intent(MainActivity.this, DetalhesPetActivity.class);
        intent.putExtra("nome", pet.nome);
        intent.putExtra("cor", pet.cor);
        intent.putExtra("raca", pet.raca);
        intent.putExtra("idade", pet.idade);
        intent.putExtra("aniversario", pet.aniversario);
        intent.putExtra("imagem", drawableId);
        startActivity(intent);
    }
}