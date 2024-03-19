package desarrolloweb.jpa.models.mappers.dto;

import lombok.Data;

@Data
public class UsuarioPartidaDTO {
    private Long id;
    private Long usuarioId;
    private Long partidaId;
    // json body example
    /*  json to create/edit a new user game
        {
            "usuarioId": 1,
            "partidaId": 1
        }
    */
}
