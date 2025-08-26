package com.example.euodeiojavaaaa;

public class Livro
{
    private String titulo;
    private String autor;
    private int anoPub;

    public Livro(String titulo, String autor, int anoPub)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
    }

    public String getInfo()
    {
        return "Titulo: " + titulo + "\n Autor: " + autor + "\n Ano de Publicação: " + anoPub;
    }
}