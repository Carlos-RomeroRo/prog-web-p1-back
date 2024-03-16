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
}
