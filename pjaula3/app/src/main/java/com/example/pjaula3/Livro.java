package com.example.pjaula3;


public class Livro {

    private String titulo;
    private String autor;
    private int anoPublicado;

    public Livro(String titulo, String autor, int anoPublicado) {

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
    }

    public String getInfo(){
        return "Titulo: " + titulo + "Autor: " + autor + "Ano Publicado: " + anoPublicado;
    }
}