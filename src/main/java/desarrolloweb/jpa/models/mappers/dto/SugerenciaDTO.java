package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SugerenciaDTO {
    private Long id;
    private String descripcion;
    private Timestamp createdAt;
}
