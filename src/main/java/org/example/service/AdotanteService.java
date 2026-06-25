package org.example.service;

import org.example.model.Adotante;
import org.example.repository.AdotanteRepository;
import org.example.repository.InMemoryAdotanteRepository;

import java.util.List;

public class AdotanteService {
    private final AdotanteRepository repository;

    public AdotanteService() {
        this.repository = new InMemoryAdotanteRepository();
    }

    public void cadastrarAdotante(Adotante adotante) {
        repository.salvar(adotante);
    }

    public List<Adotante> listarAdotantes() {
        return repository.listarTodos();
    }

    public Adotante buscarAdotante(Long id) {
        for (Adotante adotante : repository.listarTodos()) {
            if (adotante.getId().equals(id)) {
                return adotante;
            }
        }

        return null;
    }

    public void atualizarAdotante(Long id, String nome, String telefone, String email) {
        Adotante adotante = buscarAdotante(id);

        if (adotante != null) {
            adotante.setNome(nome);
            adotante.setTelefone(telefone);
            adotante.setEmail(email);
        }
    }

    public void removerAdotante(Long id) {
        Adotante adotante = buscarAdotante(id);

        if (adotante != null) {
            repository.remover(adotante);
        }
    }
}
