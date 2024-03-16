package desarrolloweb.jpa.models.mappers.mapper;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.dto.PartidaDTO;

public class PartidaMapper {

    public static PartidaDTO partidaToDto(Partida partida) {
        // handle null
        if (partida == null) {
            return null;
        }
        PartidaDTO dto = new PartidaDTO();
        dto.setId(partida.getId());
        dto.setCreadorEmail(partida.getCreadorEmail().getEmail());
        dto.setDeporte(partida.getDeporte());
        dto.setCiudad(partida.getCiudad());
        dto.setProvincia(partida.getProvincia());
        dto.setFecha(partida.getFecha());
        dto.setHoraComienzo(partida.getHora_comienzo());
        dto.setHoraFinal(partida.getHora_final());
        dto.setParticipantes(partida.getParticipantes());
        dto.setSuplentes(partida.getSuplentes());
        dto.setComentarios(partida.getComentarios());
        return dto;
    }

    public static Partida dtoToPartida(PartidaDTO dto, UsuarioRepository usuarioRepository) {
        // handle null
        if (dto == null) {
            return null;
        }
        Partida partida = new Partida();
        partida.setId(dto.getId());
        partida.setCreadorEmail(usuarioRepository.findByEmail(dto.getCreadorEmail()));
        partida.setDeporte(dto.getDeporte());
        partida.setCiudad(dto.getCiudad());
        partida.setProvincia(dto.getProvincia());
        partida.setFecha(dto.getFecha());
        partida.setHora_comienzo(dto.getHoraComienzo());
        partida.setHora_final(dto.getHoraFinal());
        partida.setParticipantes(dto.getParticipantes());
        partida.setSuplentes(dto.getSuplentes());
        partida.setComentarios(dto.getComentarios());
        return partida;
    }
}
