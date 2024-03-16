package desarrolloweb.jpa.models.mappers.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class PartidaDTO {
    private Long id;
    private String creadorEmail;
    private String deporte;
    private String ciudad;
    private String provincia;
    private Date fecha;
    private Time horaComienzo;
    private Time horaFinal;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;
    // body json example
    /*
        {
            "creadorEmail": "LJqOo@example.com",
            "deporte": "Futbol",
            "ciudad": "Madrid",
            "provincia": "Madrid",
            "fecha": "2022-01-01",
            "horaComienzo": "10:00:00",
            "horaFinal": "11:00:00",
            "participantes": 10,
            "suplentes": 5,
            "comentarios": "Comentarios"
        }
     */
}
