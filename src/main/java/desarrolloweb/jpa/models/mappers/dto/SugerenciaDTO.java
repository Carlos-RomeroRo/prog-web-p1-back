package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SugerenciaDTO {
    private Long id;
    private String descripcion;
    private Timestamp createdAt;
    // body json example
    /*
        {
            "descripcion": "sugerencia de prueba",
            "created_at": "2022-01-01 12:00:00"
        }
     */
}
