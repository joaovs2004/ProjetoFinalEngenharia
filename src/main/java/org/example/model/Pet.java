package org.example.model;

public class Pet {

    private Long id;
    private String nome;
    private String especie;
    private Integer idade;
    private boolean adotado;

    public Pet() {
    }

    public Pet(Long id, String nome, String especie, Integer idade, boolean adotado) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.adotado = adotado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }
}
