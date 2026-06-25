package org.example.repository;

import org.example.model.Adocao;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAdocaoRepository implements AdocaoRepository {
    private final List<Adocao> adocoes = new ArrayList<>();

    public void salvar(Adocao adocao) {
        adocoes.add(adocao);
    }

    public List<Adocao> listarTodos() {
        return adocoes;
    }

    public void remover(Adocao adocao) {
        adocoes.remove(adocao);
    }
}
