package desarrolloweb.jpa.models.db.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.models.AbstractIntegrationDBTest;

class MensajeRepositoryTest extends AbstractIntegrationDBTest {

        @Autowired
        private MensajeRepository mensajeRepository;
        @Autowired
        UsuarioRepository usuarioRepository;

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
                        .nombre("Carlos")
                        .password("123456")
                        .apellidos("Romero")
                        .username("Carlos_R")
                        .email("carlos@example.com")
                        .edad(25)
                        .rep_password("123456")
                        .enabled(true)
                        .foto("ruta/a/otra/foto.jpg")
                        .rol("user")
                        .created_at(Timestamp.from(Instant.now()))
                        .build();

        Mensaje message1 = Mensaje.builder()
                        .creador(user1)
                        .destinatario(user2)
                        .created_at(Timestamp.from(Instant.now()))
                        .contenido("Hola mundo")
                        .build();

        Mensaje message2 = Mensaje.builder()
                        .creador(user1)
                        .destinatario(user2)
                        .created_at(Timestamp.from(Instant.now()))
                        .contenido("Ya llegó el pedido a casa")
                        .build();

        @BeforeEach
        void setUp() {
                mensajeRepository.flush();
                mensajeRepository.deleteAll();
                usuarioRepository.flush();
                usuarioRepository.deleteAll();
                usuarioRepository.save(user1);
                usuarioRepository.save(user2);
        }

        @Test
        @DisplayName("Test save method (create)")
        void test_save() {
                // when
                Mensaje messageSaved = mensajeRepository.save(message1);
                // then
                assertNotNull(messageSaved);
        }

        @Test
        @DisplayName("Test findAll method (read)")
        void test_get_all_data() {
                // when
                mensajeRepository.save(message1);
                mensajeRepository.save(message2);
                List<Mensaje> mesagges = mensajeRepository.findAll();
                // then
                assertEquals(2, mesagges.size());
        }

        @Test
        @DisplayName("Test findById method (read)")
        void test_get_by_id() {

                // given
                // when
                Long id = mensajeRepository.save(message1).getId();
                Mensaje messageFound = mensajeRepository.findById(id).orElse(null);
                // then
                assertEquals(message1.getCreador(), messageFound.getCreador());
                assertEquals(message1.getDestinatario(), message1.getDestinatario());
                assertEquals("Hola mundo", messageFound.getContenido());
        }

        @Test
        @DisplayName("Test delete method (delete)")
        void test_delete() {
                // when
                Long id = mensajeRepository.save(message1).getId();
                mensajeRepository.deleteById(id);
                Mensaje messageFound = mensajeRepository.findById(id).orElse(null);
                // then
                assertNull(messageFound);
        }

        @Test
        @DisplayName("Test update method (update)")
        void test_update() {
                // when
                Mensaje messageSaved = mensajeRepository.save(message1);
                messageSaved.setContenido("Se ha cambiado el contenido del mensaje");
                mensajeRepository.save(messageSaved);
                Mensaje messageFound = mensajeRepository.findById(messageSaved.getId()).orElse(null);
                // then
                assertEquals("Se ha cambiado el contenido del mensaje", messageFound.getContenido());
        }
}
