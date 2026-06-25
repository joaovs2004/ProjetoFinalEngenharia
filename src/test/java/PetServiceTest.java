import org.example.model.Pet;
import org.example.repository.InMemoryPetRepository;
import org.example.repository.PetRepository;
import org.example.service.PetService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    @Test
    void deveCadastrarPet() {

        PetRepository repository = mock(InMemoryPetRepository.class);
        PetService service = new PetService(repository);

        Pet pet = new Pet(1L, "Rex", "Cachorro", 3, false);

        service.cadastrarPet(pet);

        verify(repository, times(1)).salvar(pet);
    }

    @Test
    void deveListarPets() {

        PetRepository repository = mock(InMemoryPetRepository.class);
        PetService service = new PetService(repository);

        when(repository.listarTodos())
                .thenReturn(List.of(
                        new Pet(1L, "Rex", "Cachorro", 3, false)
                ));

        List<Pet> pets = service.listarPets();

        assertEquals(1, pets.size());
    }
}