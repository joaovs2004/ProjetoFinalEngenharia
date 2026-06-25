package org.example.controller;

import org.example.model.Adotante;
import org.example.repository.InMemoryAdotanteRepository;
import org.example.service.AdotanteService;

import java.util.List;

public class AdotanteController {
    private final AdotanteService adotanteService;

    public AdotanteController() {
        this.adotanteService = new AdotanteService(new InMemoryAdotanteRepository());
    }

    public void cadastrarAdotante(String nome, String telefone, String email) {
        Adotante adotante = new Adotante(nome, telefone, email);
        adotanteService.cadastrarAdotante(adotante);
    }

    public List<Adotante> listarAdotantes() {
        return adotanteService.listarAdotantes();
    }

    public Adotante buscarAdotante(Long id) {
        return adotanteService.buscarAdotante(id);
    }

    public void atualizarAdotante(Long id, String nome, String telefone, String email) {
        adotanteService.atualizarAdotante(id, nome, telefone, email);
    }

    public void removerAdotante(Long id) {
        adotanteService.removerAdotante(id);
    }
}
