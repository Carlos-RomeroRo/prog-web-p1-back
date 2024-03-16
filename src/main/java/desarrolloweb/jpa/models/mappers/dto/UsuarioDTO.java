package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String password;
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    private Timestamp createdAt;
    // body json example
    /*
     {
        "username": "username",
        "email": "email",
        "nombre": "nombre",
        "apellidos": "apellidos",
        "edad": 0,
        "password": "password",
        "repPassword": "password",
        "enabled": true,
        "foto": "fotos",
        "rol": "admin",
        "createdAt": "createdAt"
    }
     */
}
