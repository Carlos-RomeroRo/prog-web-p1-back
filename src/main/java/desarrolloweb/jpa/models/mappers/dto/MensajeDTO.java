package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MensajeDTO {
    private Long id;
    private String creadorEmail;
    private String destinatarioEmail;
    private Timestamp createdAt;
    private String contenido;
    // body json example:

    /* json to create/edit a new message
        {
            "creadorEmail": "2KqfT@example.com",
            "destinatarioEmail": "2KqfT@example.com",
            "contenido": "Hola, ¿cómo estás?"
        }
    */
}
