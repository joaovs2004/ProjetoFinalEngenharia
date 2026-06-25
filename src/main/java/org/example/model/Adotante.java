package org.example.model;

public class Adotante {

    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Adotante() {
    }

    static long qtdAdotantes = 0;

    public Adotante(String nome, String telefone, String email) {
        this.id = ++qtdAdotantes;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
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
}
