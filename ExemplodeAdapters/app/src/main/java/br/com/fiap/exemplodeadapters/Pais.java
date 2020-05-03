package br.com.fiap.exemplodeadapters;

import java.io.Serializable;

public class Pais implements Serializable {
    private String nome;
    private String capital;
    private int bandeira;

    public Pais() {
    }

    public Pais(String nome, String capital, int bandeira) {
        this.nome = nome;
        this.capital = capital;
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }
}
