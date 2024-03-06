package desarrolloweb.jpa.models.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Builder
@Data
@Table(name = "usuarios_partidas")
@NoArgsConstructor
@AllArgsConstructor
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
