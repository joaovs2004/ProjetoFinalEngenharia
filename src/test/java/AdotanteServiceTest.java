import org.example.model.Adotante;
import org.example.repository.AdotanteRepository;
import org.example.repository.InMemoryAdotanteRepository;
import org.example.service.AdotanteService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdotanteServiceTest {

    @Test
    void deveCadastrarAdotante() {

        AdotanteRepository repository = mock(InMemoryAdotanteRepository.class);
        AdotanteService service = new AdotanteService(repository);

        Adotante adotante = new Adotante("João", "9999", "joao@email.com");

        service.cadastrarAdotante(adotante);

        verify(repository).salvar(adotante);
    }

    @Test
    void deveListarAdotantes() {

        AdotanteRepository repository = mock(InMemoryAdotanteRepository.class);
        AdotanteService service = new AdotanteService(repository);

        when(repository.listarTodos())
                .thenReturn(List.of(new Adotante("João", "9999", "email")));

        List<Adotante> result = service.listarAdotantes();

        assertEquals(1, result.size());
    }

    @Test
    void deveBuscarAdotantePorId() {

        AdotanteRepository repository = mock(InMemoryAdotanteRepository.class);
        AdotanteService service = new AdotanteService(repository);

        when(repository.listarTodos())
                .thenReturn(List.of(new Adotante("João", "9999", "email")));

        Adotante result = service.buscarAdotante(1L);

        assertNotNull(result);
        assertEquals("João", result.getNome());
    }
}