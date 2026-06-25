import org.example.model.Adocao;
import org.example.model.Adotante;
import org.example.model.Pet;
import org.example.repository.AdocaoRepository;
import org.example.service.AdocaoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdocaoServiceTest {

    @Test
    void deveRegistrarAdocao() {

        AdocaoRepository repository = mock(AdocaoRepository.class);
        AdocaoService service = new AdocaoService(repository);

        Pet pet = new Pet("Rex", "Cachorro", 3, false);
        Adotante adotante = new Adotante("João", "9999", "email");

        service.registrarAdocao(pet, adotante);

        assertTrue(pet.isAdotado());
        verify(repository).salvar(any(Adocao.class));
    }

    @Test
    void deveListarAdocoes() {

        AdocaoRepository repository = mock(AdocaoRepository.class);
        AdocaoService service = new AdocaoService(repository);

        when(repository.listarTodos()).thenReturn(List.of());

        List<Adocao> result = service.listarAdocoes();

        assertNotNull(result);
    }

    @Test
    void naoDevePermitirPetJaAdotado() {

        AdocaoRepository repository = mock(AdocaoRepository.class);
        AdocaoService service = new AdocaoService(repository);

        Pet pet = new Pet("Rex", "Cachorro", 3, true);
        Adotante adotante = new Adotante("João", "9999", "email");

        assertThrows(IllegalArgumentException.class,
                () -> service.registrarAdocao(pet, adotante));
    }
}