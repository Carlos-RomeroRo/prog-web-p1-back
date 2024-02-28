package desarrolloweb.progwebp1back.models.db.entities;

import lombok.Data;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creador_email", nullable = false)
    private Usuario creador;

    @Column(nullable = false, length = 100)
    private String deporte;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 100)
    private String provincia;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time hora_comienzo;

    @Column(nullable = false)
    private Time hora_final;

    @Column(nullable = false)
    private Integer participantes;

    @Column(nullable = false)
    private Integer suplentes;

    @Column(nullable = false, length = 100)
    private String comentarios;

    // Getters and Setters
}
