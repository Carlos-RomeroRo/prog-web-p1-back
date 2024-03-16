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
}
