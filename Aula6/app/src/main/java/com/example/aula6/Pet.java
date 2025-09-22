
package com.example.aula6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Pet {
    private String nome;
    private String cor;
    private String raca;
    private int idade;
    private String nascimento;

    public Pet(String nome, String cor, String raca, int idade, String nascimento) {
        this.nome = nome;
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
        this.nascimento = nascimento;
    }

    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public String getNascimento() { return nascimento; }
}


