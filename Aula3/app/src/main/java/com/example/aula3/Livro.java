package com.example.aula3;

public class Livro{
    private String titulo;

    private String autor;

    private int anopublicacao;

    public Livro(String titulo, String autor, int anopublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacao = anopublicacao;
    }

    public String getInfo(){
        return "Titulo: " + titulo + ", Autor: " + autor + ", Ano de publicação: " + anopublicacao;
    }
}