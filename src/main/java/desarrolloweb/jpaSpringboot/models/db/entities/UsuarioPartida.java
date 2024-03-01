package desarrolloweb.jpaSpringboot.models.db.entities;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "usuarios_partidas")
public class UsuarioPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "partida_id", referencedColumnName = "id", nullable = false)
    private Partida partida;
}
