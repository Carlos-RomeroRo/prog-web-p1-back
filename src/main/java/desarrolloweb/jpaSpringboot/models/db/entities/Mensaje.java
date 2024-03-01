package desarrolloweb.jpaSpringboot.models.db.entities;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creador_email", referencedColumnName = "email", nullable = false)
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "destinatario_email", referencedColumnName = "email", nullable = false)
    private Usuario destinatario;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(columnDefinition = "TEXT")
    private String contenido;
}
