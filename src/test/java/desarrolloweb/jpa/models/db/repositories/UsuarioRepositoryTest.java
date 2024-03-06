package desarrolloweb.jpa.models.db.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.models.AbstractIntegrationDBTest;

public class UsuarioRepositoryTest extends AbstractIntegrationDBTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    // test methods
    @Test
    void test_save() {
        //given
        Usuario user = Usuario.builder()
                .nombre("keiner")
                .password("49691722")
                .apellidos("Alvarado")
                .username("keiner5212")
                .build();
        //when
        Usuario usersaved = usuarioRepository.save(user);
        //then
        assertNotNull(usersaved);
    }
}
