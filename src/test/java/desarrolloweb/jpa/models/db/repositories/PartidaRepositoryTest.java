package desarrolloweb.jpa.models.db.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import desarrolloweb.models.AbstractIntegrationDBTest;

class PartidaRepositoryTest extends AbstractIntegrationDBTest {

    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

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

    @BeforeEach
    void setUp() {
        partidaRepository.flush();
        partidaRepository.deleteAll();
        usuarioRepository.flush();
        usuarioRepository.deleteAll();
        usuarioRepository.save(user1);
    }

    @Test
    @DisplayName("Test save method (create)")
    void test_save() {
        // given
        usuarioRepository.save(user1);
        // when
        Partida matchSaved = partidaRepository.save(match);
        // then
        assertNotNull(matchSaved);
    }

    @Test
    @DisplayName("Test findById method (read)")
    void test_get_by_id() {
        // when
        Long id = partidaRepository.save(match).getId();
        Partida matchFound = partidaRepository.findById(id).orElse(null);
        // then
        assertNotNull(matchFound);
        assertEquals(match.getCreadorEmail(), user1);
        assertEquals("Futbol", matchFound.getDeporte());
        assertEquals("Buenos Aires", matchFound.getCiudad());
        assertEquals("Provincia de Buenos Aires", matchFound.getProvincia());
        assertEquals(Date.valueOf(LocalDate.now()), matchFound.getFecha());
        assertEquals(Time.valueOf("09:00:00"), matchFound.getHora_comienzo());
        assertEquals(Time.valueOf("20:00:00"), matchFound.getHora_final());
        assertEquals(11, matchFound.getParticipantes());
        assertEquals(7, matchFound.getSuplentes());
        assertEquals("El futbol es el deporte rey", matchFound.getComentarios());
    }

    @Test
    @DisplayName("Test update method (update)")
    void test_update() {
        // when
        partidaRepository.save(match);
        match.setComentarios("El futbol es el deporte mejorado");
        Partida matchFound = partidaRepository.findById(match.getId()).orElse(null);
        // then
        assertEquals("El futbol es el deporte mejorado", matchFound.getComentarios());
    }

    @Test
    @DisplayName("Test delete method (delete)")
    void test_delete() {
        // when
        partidaRepository.save(match);
        partidaRepository.deleteById(match.getId());
        Partida matchFound = partidaRepository.findById(match.getId()).orElse(null);
        // then
        assertEquals(null, matchFound);
    }

    @Test
    @DisplayName("Test findAll method (read)")
    void test_get_all_data() {
        partidaRepository.save(match);
        List<Partida> matches = partidaRepository.findAll();
        // then
        assertEquals(1, matches.size());
    }

}
