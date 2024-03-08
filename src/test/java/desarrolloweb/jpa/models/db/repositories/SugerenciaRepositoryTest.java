package desarrolloweb.jpa.models.db.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.models.AbstractIntegrationDBTest;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {

    @Autowired
    SugerenciaRepository sugerenciaRepository;

    // given
    Sugerencia suggestion1 = Sugerencia.builder()
            .descripcion("Hay que mejorar algunos aspectos del apartamento")
            .created_at(Timestamp.from(Instant.now()))
            .build();
    Sugerencia suggestion2 = Sugerencia.builder()
            .descripcion("Hay que reparar cosas de la casa")
            .created_at(Timestamp.from(Instant.now()))
            .build();

    @BeforeEach
    void setUp() {
        sugerenciaRepository.flush();
        sugerenciaRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save method (create)")
    void test_save() {
        // when
        Sugerencia suggestionSaved = sugerenciaRepository.save(suggestion1);
        // then
        assertNotNull(suggestionSaved);
    }

    @Test
    @DisplayName("Test findAll method (read)")
    void test_get_all_data() {
        // when
        sugerenciaRepository.save(suggestion1);
        sugerenciaRepository.save(suggestion2);
        List<Sugerencia> suggestions = sugerenciaRepository.findAll();
        // then
        assertEquals(2, suggestions.size());
    }

    @Test
    @DisplayName("Test findById method (read)")
    void test_by_id() {
        // when
        Long id = sugerenciaRepository.save(suggestion1).getId();
        Sugerencia suggestionFound = sugerenciaRepository.findById(id).orElse(null);

        // then
        assertNotNull(suggestionFound);
        assertEquals(id, suggestionFound.getId());
        assertEquals("Hay que mejorar algunos aspectos del apartamento", suggestionFound.getDescripcion());
    }

    @Test
    @DisplayName("Test delete method (delete)")
    void test_delete() {
        // when
        Long id = sugerenciaRepository.save(suggestion1).getId();
        sugerenciaRepository.delete(suggestion1);
        Sugerencia suggestionFound = sugerenciaRepository.findById(id).orElse(null);

        // then
        assertNull(suggestionFound);
    }

    @Test
    @DisplayName("Test update method (update)")
    void test_update() {
        // when
        Sugerencia suggestionSaved = sugerenciaRepository.save(suggestion1);
        suggestionSaved.setDescripcion("Ya se ha mejorado el apartamento");
        Sugerencia suggestionFound = sugerenciaRepository.findById(suggestionSaved.getId()).orElse(null);
        // then
        assertEquals("Ya se ha mejorado el apartamento", suggestionFound.getDescripcion());

    }

}
