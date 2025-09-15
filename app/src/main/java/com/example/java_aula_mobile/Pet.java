package com.example.java_aula_mobile;

import java.io.Serializable;

public class Pet implements Serializable {
    private String nome;
    private String cor;
    private String raca;
    private int idade;
    private String aniversario;
    private int imagemResId;
    private String sexo;

    // Construtor
    public Pet(String nome, String cor, String raca, int idade, String aniversario, int imagemResId, String sexo) {
        this.nome = nome;
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
        this.aniversario = aniversario;
        this.imagemResId = imagemResId;
        this.sexo = sexo;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public String getAniversario() { return aniversario; }
    public int getImagemResId() { return imagemResId; }

    public String getSexo() { return sexo; }
}
