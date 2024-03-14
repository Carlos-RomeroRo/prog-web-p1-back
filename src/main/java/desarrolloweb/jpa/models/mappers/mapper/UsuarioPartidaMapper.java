package desarrolloweb.jpa.models.mappers.mapper;

import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.dto.UsuarioPartidaDTO;

public class UsuarioPartidaMapper {

    public static UsuarioPartidaDTO usuarioPartidaToDto(UsuarioPartida usuarioPartida) {
        UsuarioPartidaDTO dto = new UsuarioPartidaDTO();
        dto.setId(usuarioPartida.getId());
        dto.setUsuarioId(usuarioPartida.getUsuario().getId());
        dto.setPartidaId(usuarioPartida.getPartida().getId());
        return dto;
    }

    public static UsuarioPartida dtoToUsuarioPartida(UsuarioPartidaDTO dto, UsuarioRepository usuarioRepository,
            PartidaRepository partidaRepository) {
        UsuarioPartida usuarioPartida = new UsuarioPartida();
        usuarioPartida.setId(dto.getId());
        usuarioPartida.setUsuario(usuarioRepository.findById(dto.getUsuarioId()).orElse(null));
        usuarioPartida.setPartida(partidaRepository.findById(dto.getPartidaId()).orElse(null));
        return usuarioPartida;
    }
}
