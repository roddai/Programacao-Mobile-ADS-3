package com.example.aula06tarefa;

import android.os.Parcel;
import android.os.Parcelable;

public class Pet implements Parcelable {
    private String nome;
    private String cor;
    private String raca;
    private int idade;
    private String aniversario;

    public Pet(String nome, String cor, String raca, int idade, String aniversario) {
        this.nome = nome;
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
        this.aniversario = aniversario;
    }

    // Construtor para criar a partir do Parcel
    protected Pet(Parcel in) {
        nome = in.readString();
        cor = in.readString();
        raca = in.readString();
        idade = in.readInt();
        aniversario = in.readString();
    }

    // Parcelable.Creator para criar objetos Pet a partir do Parcel
    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // Como escrever os dados no Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(cor);
        dest.writeString(raca);
        dest.writeInt(idade);
        dest.writeString(aniversario);
    }

    // Getters
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public String getAniversario() { return aniversario; }
}