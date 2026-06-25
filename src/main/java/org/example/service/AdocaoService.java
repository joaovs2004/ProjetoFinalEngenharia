package org.example.service;

import org.example.model.Adocao;
import org.example.model.Adotante;
import org.example.model.Pet;
import org.example.repository.AdocaoRepository;
import org.example.repository.InMemoryAdocaoRepository;

import java.time.LocalDate;
import java.util.List;

public class AdocaoService {
    private final AdocaoRepository repository;

    public AdocaoService() {
        this.repository = new InMemoryAdocaoRepository();
    }

    public void registrarAdocao(Long id, Pet pet, Adotante adotante) {
        if (pet.isAdotado()) {
            throw new IllegalArgumentException("O pet já foi adotado.");
        }

        pet.setAdotado(true);

        Adocao adocao = new Adocao(
                id,
                pet,
                adotante,
                LocalDate.now()
        );

        repository.salvar(adocao);
    }

    public List<Adocao> listarAdocoes() {
        return repository.listarTodos();
    }

    public Adocao buscarAdocao(Long id) {
        for (Adocao adocao : repository.listarTodos()) {
            if (adocao.getId().equals(id)) {
                return adocao;
            }

        }

        return null;
    }

    public void removerAdocao(Long id) {
        Adocao adocao = buscarAdocao(id);

        if (adocao != null) {
            adocao.getPet().setAdotado(false);
            repository.remover(adocao);
        }
    }
}
