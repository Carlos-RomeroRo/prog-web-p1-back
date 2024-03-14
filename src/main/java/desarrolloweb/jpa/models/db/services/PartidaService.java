package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.dto.PartidaDTO;
import desarrolloweb.jpa.models.mappers.mapper.PartidaMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<PartidaDTO> getAll() {
        List<Partida> partidas = partidaRepository.findAll();
        return partidas.stream()
                .map(PartidaMapper::partidaToDto)
                .collect(Collectors.toList());
    }

    public PartidaDTO get(Long id) {
        Partida partida = partidaRepository.findById(id).orElse(null);
        if (partida == null) {
            return null;
        }
        return PartidaMapper.partidaToDto(partida);
    }

    public PartidaDTO create(PartidaDTO partidaDTO) {
        Partida partida = PartidaMapper.dtoToPartida(partidaDTO, usuarioRepository);
        partida = partidaRepository.save(partida);
        return PartidaMapper.partidaToDto(partida);
    }

    public Boolean edit(PartidaDTO partidaDTO) {
        try {

            Partida partida = PartidaMapper.dtoToPartida(partidaDTO, usuarioRepository);
            partidaRepository.save(partida);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        partidaRepository.deleteById(id);
    }
}
