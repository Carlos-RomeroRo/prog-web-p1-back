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
    /*
        {
            "creadorEmail": "2KqfT@example.com",
            "destinatarioEmail": "2KqfT@example.com",
            "createdAt": "2021-03-06T16:00:00.000Z",
            "contenido": "Hola, ¿cómo estás?"
        }
    */
}
