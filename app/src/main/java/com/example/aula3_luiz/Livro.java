package com.example.aula3_luiz;

public class Livro {

    private String titulo;
    private String autor;

    private int anoPublicacao;

    public Livro(String titulo,String autor, int anoPublicacao){
        this.titulo = titulo;
        this.autor=autor;
        this.anoPublicacao= anoPublicacao;
    }
    public String getInfo(){

        return "Titulo:" + titulo + "Autor:" + autor + "Ano:" + anoPublicacao;
    }
}
