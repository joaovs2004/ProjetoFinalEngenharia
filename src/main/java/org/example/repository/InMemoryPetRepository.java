package org.example.repository;

import org.example.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPetRepository implements PetRepository {
    private final List<Pet> pets = new ArrayList<>();

    public void salvar(Pet pet) {
        pets.add(pet);
    }

    public List<Pet> listarTodos() {
        return pets;
    }

    public void remover(Pet pet) {
        pets.remove(pet);
    }
}
