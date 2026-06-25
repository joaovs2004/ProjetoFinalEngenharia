package org.example.repository;

import org.example.model.Adocao;

import java.util.List;

public interface AdocaoRepository {
    void salvar(Adocao adocao);
    List<Adocao> listarTodos();
    void remover(Adocao adocao);
}
