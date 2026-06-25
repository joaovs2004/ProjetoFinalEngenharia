package org.example.repository;

import org.example.model.Adotante;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAdotanteRepository implements AdotanteRepository {
    private final List<Adotante> adotantes = new ArrayList<>();

    public void salvar(Adotante adotante) {
        adotantes.add(adotante);
    }

    public List<Adotante> listarTodos() {
        return adotantes;
    }

    public void remover(Adotante adotante) {
        adotantes.remove(adotante);
    }
}
