package br.com.fiap.listagemdedados;

import java.io.Serializable;

public class Contato implements Serializable {
    private String nome;
    private String telefone;
    private String email;
    private Integer foto;

    public Contato() {
    }

    public Contato(String nome, String telefone, String email, Integer foto) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
