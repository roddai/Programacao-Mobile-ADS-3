package com.example.euprovavelmentenaodeviacolocaronometaograndemaseuireitestarolimitedecaracteresqueonome;

public class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getInfo(){
    return "O nome dessa Porqueira é: " + titulo + " Quem criou esse troço foi: " + autor + "Foi postado no fundo do inferno no  ano de: " + anoPublicacao;
    }
}

