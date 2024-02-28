package desarrolloweb.progwebp1back.models.db.entities;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false, length = 100)
    private String password;

    @Transient
    private String rep_password;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(length = 255)
    private String foto;

    @Column(length = 100)
    private String rol;

    @Column(nullable = false)
    private Timestamp created_at;
}