package desarrolloweb.jpa.models.mappers.dto;

import lombok.Data;

@Data
public class UsuarioPartidaDTO {
    private Long id;
    private Long usuarioId;
    private Long partidaId;
    // json body example
    /* 
        {
            "usuarioId": 1,
            "partidaId": 1
        }
    */
}
