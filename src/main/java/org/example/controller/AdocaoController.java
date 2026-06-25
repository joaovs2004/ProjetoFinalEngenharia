package org.example.controller;

import org.example.model.Adocao;
import org.example.model.Adotante;
import org.example.model.Pet;
import org.example.repository.InMemoryAdocaoRepository;
import org.example.service.AdocaoService;

import java.util.List;

public class AdocaoController {
    private final AdocaoService adocaoService;

    public AdocaoController() {
        this.adocaoService = new AdocaoService(new InMemoryAdocaoRepository());
    }

    public void registrarAdocao(Pet pet, Adotante adotante) {
        adocaoService.registrarAdocao(pet, adotante);
    }

    public List<Adocao> listarAdocoes() {
        return adocaoService.listarAdocoes();
    }

    public Adocao buscarAdocao(Long id) {
        return adocaoService.buscarAdocao(id);
    }

    public void removerAdocao(Long id) {
        adocaoService.removerAdocao(id);
    }
}
