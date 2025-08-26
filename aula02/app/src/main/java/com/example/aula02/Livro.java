package com.example.aula02;

public class Livro{
    private String Titulo;
    private String Autor;
    private int AnoPub;

    public Livro(String Titulo, String Autor, int AnoPub) //getinfo = gets e sets
    {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.AnoPub = AnoPub;
    }
    public String getInfo()
    {
        return "Titulo: " + Titulo + "Autor: " + Autor + "Ano de publicação: " + AnoPub;
    }
}