package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.jpa.models.db.repositories.UsuariosPartidaRepository;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.UsuarioPartidaMapper;
import desarrolloweb.jpa.models.mappers.dto.UsuarioPartidaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosPartidaService {

    @Autowired
    private UsuariosPartidaRepository usuariosPartidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    public List<UsuarioPartidaDTO> getAll() {
        List<UsuarioPartida> usuarioPartidas = usuariosPartidaRepository.findAll();
        return usuarioPartidas.stream()
                .map(UsuarioPartidaMapper::usuarioPartidaToDto)
                .collect(Collectors.toList());
    }

    public UsuarioPartidaDTO get(Long id) {
        UsuarioPartida usuarioPartida = usuariosPartidaRepository.findById(id).orElse(null);
        if (usuarioPartida == null) {
            return null;
        }
        return UsuarioPartidaMapper.usuarioPartidaToDto(usuarioPartida);
    }

    public UsuarioPartidaDTO create(UsuarioPartidaDTO usuarioPartidaDTO) {
        UsuarioPartida usuarioPartida = UsuarioPartidaMapper.dtoToUsuarioPartida(usuarioPartidaDTO, usuarioRepository, partidaRepository);
        usuarioPartida = usuariosPartidaRepository.save(usuarioPartida);
        return UsuarioPartidaMapper.usuarioPartidaToDto(usuarioPartida);
    }

    public Boolean edit(UsuarioPartidaDTO usuarioPartidaDTO) {
        try {
            UsuarioPartida usuarioPartida = UsuarioPartidaMapper.dtoToUsuarioPartida(usuarioPartidaDTO, usuarioRepository, partidaRepository);
            usuariosPartidaRepository.save(usuarioPartida);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        usuariosPartidaRepository.deleteById(id);
    }
}
