package desarrolloweb.jpa.models.db.repositories;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.models.AbstractIntegrationDBTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;

class UsuarioRepositoryTest extends AbstractIntegrationDBTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    // test methods
    @Test
    void test_save() {
        // given
        Usuario user = Usuario.builder()
                .nombre("keiner")
                .password("49691722")
                .apellidos("Alvarado")
                .username("keiner5212")
                .email("keiner@example.com") 
                .edad(30) 
                .rep_password("49691722") 
                .enabled(true) 
                .foto("ruta/a/la/foto.jpg") 
                .rol("user") 
                .created_at(Timestamp.from(Instant.now())) 
                .build();
        // when
        Usuario userSaved = usuarioRepository.save(user);
        // then
        assertNotNull(userSaved);
    }
}
