package desarrolloweb.progwebp1back.models.db.entities;

import lombok.Data;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creador_email", nullable = false)
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "destinatario_email", nullable = false)
    private Usuario destinatario;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    // Getters and Setters
}
