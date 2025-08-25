package com.example.projectaula3;

public class Livro{
    private String titulo;

    private String autor;

    private int anoPublicacao;

    public Livro (String titulo, String autor, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao;
    }

    public String getInfo(){
        return "Titulo: " + titulo + "Autor: " + autor + "Ano: " + anoPublicacao;
    }
}