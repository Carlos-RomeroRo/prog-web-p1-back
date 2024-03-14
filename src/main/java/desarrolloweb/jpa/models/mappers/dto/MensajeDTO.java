package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class MensajeDTO {
    @Getter @Setter private Long id;
    @Getter @Setter private String creadorEmail;
    @Getter @Setter private String destinatarioEmail;
    @Getter @Setter private Timestamp createdAt;
    @Getter @Setter private String contenido;
}
