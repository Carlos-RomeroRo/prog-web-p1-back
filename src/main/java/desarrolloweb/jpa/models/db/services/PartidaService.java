package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.dto.PartidaDTO;
import desarrolloweb.jpa.models.mappers.mapper.PartidaMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all the games from the database
     * 
     * @return List<PartidaDTO> the list of games
     */
    public List<PartidaDTO> getAll() {
        List<Partida> partidas = partidaRepository.findAll();
        return partidas.stream()
                .map(PartidaMapper::partidaToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a game from the database
     * 
     * @param id the id of the game
     * @return PartidaDTO the game
     */
    public PartidaDTO get(Long id) {
        Partida partida;
        try {
            partida = partidaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return PartidaMapper.partidaToDto(partida);
    }

    /**
     * Create a new game
     * 
     * @param partidaDTO the game
     * @return PartidaDTO the created game
     */
    public PartidaDTO create(PartidaDTO partidaDTO) {
        Partida partida;
        try {
            partida = PartidaMapper.dtoToPartida(partidaDTO, usuarioRepository);
            partida = partidaRepository.save(partida);
        } catch (Exception e) {
            log.error("Error on create", e.getMessage());
            return null;
        }
        return PartidaMapper.partidaToDto(partida);
    }

    /**
     * Edit a game
     * 
     * @param partidaDTO the game
     * @param original   the original game
     * @return Boolean true if the game was edited
     */
    public Boolean edit(PartidaDTO partidaDTO, PartidaDTO original) {
        if (original == null) {
            return false;
        }

        
        try {
            partidaDTO.setId(original.getId());
            Partida partida = PartidaMapper.dtoToPartida(partidaDTO, usuarioRepository);
            partidaRepository.save(partida);
        } catch (Exception e) {
            log.error("Error on edit", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Delete a game
     * 
     * @param id the id of the game
     * @return Boolean true if the game was deleted
     */
    public Boolean delete(Long id) {
        try {
            partidaRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error on delete", e.getMessage());
            return false;
        }
        return true;
    }
}
