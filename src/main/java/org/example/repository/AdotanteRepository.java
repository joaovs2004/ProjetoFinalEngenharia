package org.example.repository;

import org.example.model.Adotante;

import java.util.List;

public interface AdotanteRepository {
    void salvar(Adotante adotante);
    List<Adotante> listarTodos();
    void remover(Adotante adotante);
}
