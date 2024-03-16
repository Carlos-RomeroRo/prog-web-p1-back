package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.jpa.models.db.repositories.UsuariosPartidaRepository;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.UsuarioPartidaMapper;
import lombok.extern.slf4j.Slf4j;
import desarrolloweb.jpa.models.mappers.dto.UsuarioPartidaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuariosPartidaService {

    @Autowired
    private UsuariosPartidaRepository usuariosPartidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    /**
     * Get all the users' games from the database
     * 
     * @return List<UsuarioPartidaDTO> the list of users' games
     */
    public List<UsuarioPartidaDTO> getAll() {
        List<UsuarioPartida> usuarioPartidas = usuariosPartidaRepository.findAll();
        return usuarioPartidas.stream()
                .map(UsuarioPartidaMapper::usuarioPartidaToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a user's game from the database
     * 
     * @param id the id of the user's game
     * @return UsuarioPartidaDTO the user's game
     */
    public UsuarioPartidaDTO get(Long id) {
        UsuarioPartida usuarioPartida;
        try {
            usuarioPartida = usuariosPartidaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return UsuarioPartidaMapper.usuarioPartidaToDto(usuarioPartida);
    }

    /**
     * Create a user's game in the database
     * 
     * @param usuarioPartidaDTO the user's game
     * @return UsuarioPartidaDTO the created user's game
     */
    public UsuarioPartidaDTO create(UsuarioPartidaDTO usuarioPartidaDTO) {
        UsuarioPartida usuarioPartida;
        try {
            usuarioPartida = UsuarioPartidaMapper.dtoToUsuarioPartida(usuarioPartidaDTO, usuarioRepository,
                    partidaRepository);
            usuarioPartida = usuariosPartidaRepository.save(usuarioPartida);
        } catch (Exception e) {
            log.error("Error on create", e.getMessage());
            return null;
        }
        return UsuarioPartidaMapper.usuarioPartidaToDto(usuarioPartida);
    }

    /**
     * Edit a user's game in the database
     * 
     * @param usuarioPartidaDTO the user's game
     * @return Boolean true if the user's game was edited
     */
    public Boolean edit(UsuarioPartidaDTO usuarioPartidaDTO) {
        try {
            UsuarioPartida usuarioPartida = UsuarioPartidaMapper.dtoToUsuarioPartida(usuarioPartidaDTO,
                    usuarioRepository, partidaRepository);
            usuariosPartidaRepository.save(usuarioPartida);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Delete a user's game in the database
     * 
     * @param id the id of the user's game
     * @return Boolean true if the user's game was deleted
     */
    public Boolean delete(Long id) {
        try {
            usuariosPartidaRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error on delete", e.getMessage());
            return false;
        }
        return true;
    }
}
