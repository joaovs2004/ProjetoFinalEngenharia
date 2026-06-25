package org.example.service;

import org.example.model.Pet;
import org.example.repository.InMemoryPetRepository;
import org.example.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    private final PetRepository repository;

    public PetService() {
        this.repository = new InMemoryPetRepository();
    }

    public void cadastrarPet(Pet pet) {
        repository.salvar(pet);
    }

    public List<Pet> listarPets() {
        return repository.listarTodos();
    }

    public List<Pet> listarPetsDisponiveis() {
        List<Pet> disponiveis = new ArrayList<>();

        for (Pet pet : repository.listarTodos()) {
            if (!pet.isAdotado()) {
                disponiveis.add(pet);
            }
        }

        return disponiveis;
    }

    public Pet buscarPet(Long id) {
        for (Pet pet : repository.listarTodos()) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }

        return null;
    }

    public void adotarPet(Long id) {
        Pet pet = buscarPet(id);

        if (pet != null) {
            pet.setAdotado(true);
        }
    }

    public void removerPet(Long id) {
        Pet pet = buscarPet(id);

        if (pet != null) {
            repository.remover(pet);
        }
    }
}
