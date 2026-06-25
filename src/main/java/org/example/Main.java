package org.example;


import org.example.controller.AdocaoController;
import org.example.controller.AdotanteController;
import org.example.controller.PetController;

public class Main {
    static void main() {
        PetController petController = new PetController();
        AdotanteController adotanteController = new AdotanteController();
        AdocaoController adocaoController = new AdocaoController();

        int opcao;

        do {
            IO.println("\n===== SISTEMA DE ADOÇÃO DE PETS =====");
            IO.println("1 - Cadastrar Pet");
            IO.println("2 - Listar Pets");
            IO.println("3 - Cadastrar Adotante");
            IO.println("4 - Listar Adotantes");
            IO.println("5 - Registrar Adoção");
            IO.println("6 - Listar Adoções");
            IO.println("0 - Sair");
            IO.print("Escolha: ");

            opcao = Integer.parseInt(IO.readln());

            switch (opcao) {

                case 1 -> {
                    IO.print("ID: ");
                    long id = Long.parseLong(IO.readln());

                    IO.print("Nome: ");
                    String nome = IO.readln();

                    IO.print("Espécie: ");
                    String especie = IO.readln();

                    IO.print("Idade: ");
                    int idade = Integer.parseInt(IO.readln());

                    petController.cadastrarPet(id, nome, especie, idade);

                    IO.println("Pet cadastrado!");
                }

                case 2 -> {
                    IO.println("\n--- PETS ---");
                    petController.listarPets()
                            .forEach(p -> IO.println(
                                    p.getId() + " - " + p.getNome() + " - " + p.getEspecie()
                            ));
                }

                case 3 -> {
                    IO.print("ID: ");
                    long id = Long.parseLong(IO.readln());

                    IO.print("Nome: ");
                    String nome = IO.readln();

                    IO.print("Telefone: ");
                    String telefone = IO.readln();

                    IO.print("Email: ");
                    String email = IO.readln();

                    adotanteController.cadastrarAdotante(id, nome, telefone, email);

                    IO.println("Adotante cadastrado!");
                }

                case 4 -> {
                    IO.println("\n--- ADOTANTES ---");
                    adotanteController.listarAdotantes()
                            .forEach(a -> IO.println(
                                    a.getId() + " - " + a.getNome()
                            ));
                }

                case 5 -> {
                    IO.print("ID da Adoção: ");
                    long id = Long.parseLong(IO.readln());

                    IO.print("ID do Pet: ");
                    long petId = Long.parseLong(IO.readln());

                    IO.print("ID do Adotante: ");
                    long adotanteId = Long.parseLong(IO.readln());

                    var pet = petController.buscarPet(petId);
                    var adotante = adotanteController.buscarAdotante(adotanteId);

                    adocaoController.registrarAdocao(id, pet, adotante);

                    IO.println("Adoção registrada!");
                }

                case 6 -> {
                    IO.println("\n--- ADOÇÕES ---");
                    adocaoController.listarAdocoes()
                            .forEach(a -> IO.println(
                                    a.getId()
                                            + " | Pet: " + a.getPet().getNome()
                                            + " | Adotante: " + a.getAdotante().getNome()
                            ));
                }

                case 0 -> IO.println("Saindo...");

                default -> IO.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
