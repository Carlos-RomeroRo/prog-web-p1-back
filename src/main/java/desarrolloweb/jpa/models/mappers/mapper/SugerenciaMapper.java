package desarrolloweb.jpa.models.mappers.mapper;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.jpa.models.mappers.dto.SugerenciaDTO;

public class SugerenciaMapper {
    public static SugerenciaDTO sugerenciaToDto(Sugerencia sugerencia) {
        SugerenciaDTO dto = new SugerenciaDTO();
        dto.setId(sugerencia.getId());
        dto.setDescripcion(sugerencia.getDescripcion());
        dto.setCreatedAt(sugerencia.getCreated_at());
        return dto;
    }

    public static Sugerencia dtoToSugerencia(SugerenciaDTO dto) {
        Sugerencia sugerencia = new Sugerencia();
        sugerencia.setId(dto.getId());
        sugerencia.setDescripcion(dto.getDescripcion());
        sugerencia.setCreated_at(dto.getCreatedAt());
        return sugerencia;
    }
}
