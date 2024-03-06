package desarrolloweb.jpa.models.db.repositories;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.models.AbstractIntegrationDBTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class UsuarioRepositoryTest extends AbstractIntegrationDBTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.flush();
        usuarioRepository.deleteAll();
    }

    // test methods
    @Test
    @DisplayName("Test save method (create)")
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

    @Test
    @DisplayName("Test findAll method (read)")
    void test_get_all_data() {
        // given
        Usuario user1 = Usuario.builder()
                .nombre("keiner")
                .password("49691722")
                .apellidos("Alvarado")
                .username("keiner5212")
                .email("keiner1@example.com")
                .edad(30)
                .rep_password("49691722")
                .enabled(true)
                .foto("ruta/a/la/foto.jpg")
                .rol("user")
                .created_at(Timestamp.from(Instant.now()))
                .build();

        Usuario user2 = Usuario.builder()
                .nombre("María")
                .password("123456")
                .apellidos("García")
                .username("maria_g")
                .email("maria@example.com")
                .edad(25)
                .rep_password("123456")
                .enabled(true)
                .foto("ruta/a/otra/foto.jpg")
                .rol("user")
                .created_at(Timestamp.from(Instant.now()))
                .build();

        // when
        usuarioRepository.save(user1);
        usuarioRepository.save(user2);

        List<Usuario> users = usuarioRepository.findAll();
        // then
        assertEquals(2, users.size());
    }

    @Test
    @DisplayName("Test findById method (read)")
    void test_get_by_id() {
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
        Long id = usuarioRepository.save(user).getId();

        Usuario userFound = usuarioRepository.findById(id).orElse(null);

        // then
        assertEquals("keiner", userFound.getNombre());
        assertEquals("keiner5212", userFound.getUsername());
        assertEquals("keiner@example.com", userFound.getEmail());
        assertEquals(30, (int) userFound.getEdad());
        assertEquals("49691722", userFound.getPassword());
        assertEquals("user", userFound.getRol());
        assertEquals("ruta/a/la/foto.jpg", userFound.getFoto());
    }

    @Test
    @DisplayName("Test delete method (delete)")
    void test_delete() {
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
        Long id = usuarioRepository.save(user).getId();
        usuarioRepository.deleteById(id);
        Usuario userFound = usuarioRepository.findById(id).orElse(null);

        // then
        assertNull(userFound);
    }

    @Test
    @DisplayName("Test update method (update)")
    void test_update() {
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
        userSaved.setRol("admin");
        usuarioRepository.save(userSaved);
        Usuario userFound = usuarioRepository.findById(userSaved.getId()).orElse(null);

        // then
        assertEquals("admin", userFound.getRol());
    }
}
