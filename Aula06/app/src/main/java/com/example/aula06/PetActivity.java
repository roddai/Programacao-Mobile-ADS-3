package com.example.aula06;

public class PetActivity{
    private String Nome;
    private String Cor;
    private int Idade;

    public PetActivity(String Nome, String Cor,int Indade){
        this.Nome = Nome;
        this.Cor = Cor;
        this.Idade = Idade;
    }

    public String getInfo() {
        return "Nome: "+ Nome +"\nCor:" + "\nIdade: " + Idade;
    }
}