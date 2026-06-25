package org.example.model;

import java.time.LocalDate;

public class Adocao {

    private Long id;
    private Pet pet;
    private Adotante adotante;
    private LocalDate dataAdocao;

    public Adocao() {
    }

    public Adocao(Long id, Pet pet, Adotante adotante, LocalDate dataAdocao) {
        this.id = id;
        this.pet = pet;
        this.adotante = adotante;
        this.dataAdocao = dataAdocao;
    }

    public Long getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
}
