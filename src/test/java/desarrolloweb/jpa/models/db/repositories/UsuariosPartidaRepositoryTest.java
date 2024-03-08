package desarrolloweb.jpa.models.db.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.models.AbstractIntegrationDBTest;

class UsuariosPartidaRepositoryTest extends AbstractIntegrationDBTest {

    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuariosPartidaRepository usuariosPartidaRepository;

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

    Partida match = Partida.builder()
            .creadorEmail(user1)
            .deporte("Futbol")
            .ciudad("Buenos Aires")
            .provincia("Provincia de Buenos Aires")
            .fecha(Date.valueOf(LocalDate.now()))
            .hora_comienzo(Time.valueOf("09:00:00"))
            .hora_final(Time.valueOf("20:00:00"))
            .participantes(11)
            .suplentes(7)
            .comentarios("El futbol es el deporte rey")
            .build();

    UsuarioPartida up = UsuarioPartida.builder()
            .partida(match)
            .usuario(user1)
            .build();

    @BeforeEach
    void setUp() {
        partidaRepository.flush();
        partidaRepository.deleteAll();
        usuarioRepository.flush();
        usuarioRepository.deleteAll();
        usuarioRepository.save(user1);
        partidaRepository.save(match);
    }

    @Test
    @DisplayName("Test save method (create)")
    void test_save() {
        // when
        UsuarioPartida upSaved = usuariosPartidaRepository.save(up);
        // then
        assertNotNull(upSaved);
    }

    // getall method
    @Test
    @DisplayName("Test findAll method (read)")
    void test_get_all_data() {
        // when
        usuariosPartidaRepository.save(up);
        List<UsuarioPartida> upList = usuariosPartidaRepository.findAll();
        // then
        assertEquals(1, upList.size());
    }

    @Test
    @DisplayName("Test findById method (read)")
    void test_by_id() {
        // when
        Long id = usuariosPartidaRepository.save(up).getId();
        UsuarioPartida upFound = usuariosPartidaRepository.findById(id).orElse(null);

        // then
        assertNotNull(upFound);
    }

    @Test
    @DisplayName("Test delete method (delete)")
    void test_delete() {
        // when
        Long id = usuariosPartidaRepository.save(up).getId();
        usuariosPartidaRepository.deleteById(id);
        UsuarioPartida upFound = usuariosPartidaRepository.findById(id).orElse(null);

        // then
        assertNull(upFound);
    }
}
