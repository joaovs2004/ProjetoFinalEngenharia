package org.example.controller;

import org.example.model.Pet;
import org.example.service.PetService;

import java.util.List;

public class PetController {

    private final PetService petService;

    public PetController() {
        this.petService = new PetService();
    }

    public void cadastrarPet(Long id, String nome, String especie, Integer idade) {
        Pet pet = new Pet(id, nome, especie, idade, false);
        petService.cadastrarPet(pet);
    }

    public List<Pet> listarPets() {
        return petService.listarPets();
    }

    public List<Pet> listarPetsDisponiveis() {
        return petService.listarPetsDisponiveis();
    }

    public void adotarPet(Long id) {
        petService.adotarPet(id);
    }

    public Pet buscarPet(Long id) {
        return petService.buscarPet(id);
    }

    public void removerPet(Long id) {
        petService.removerPet(id);
    }
}
