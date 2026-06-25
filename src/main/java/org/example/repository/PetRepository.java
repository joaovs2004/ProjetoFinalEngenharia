package org.example.repository;

import org.example.model.Pet;

import java.util.List;

public interface PetRepository {
    void salvar(Pet pet);
    List<Pet> listarTodos();
    void remover(Pet pet);
}
