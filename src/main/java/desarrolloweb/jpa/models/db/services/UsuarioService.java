package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.UsuarioMapper;
import lombok.extern.slf4j.Slf4j;
import desarrolloweb.jpa.models.mappers.dto.UsuarioDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all the games from the database
     * 
     * @return List<UsuarioDTO> the list of games
     */
    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::usuarioToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a game from the database
     * 
     * @param id the id of the game
     * @return UsuarioDTO the game
     */
    public UsuarioDTO get(Long id) {
        Usuario usuario;
        try {
            usuario = usuarioRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return UsuarioMapper.usuarioToDto(usuario);
    }

    /**
     * Get a game from the database
     * 
     * @param email the email of the game
     * @return UsuarioDTO the game
     */
    public UsuarioDTO findByEmail(String email) {
        Usuario usuario;
        try {
            usuario = usuarioRepository.findByEmail(email);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return UsuarioMapper.usuarioToDto(usuario);
    }

    /**
     * Create a new game
     * 
     * @param usuarioDTO the game
     * @return UsuarioDTO the created game
     */
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario;
        try {
            usuarioDTO.setCreatedAt(Timestamp.from(java.time.Instant.now()));
            usuario = UsuarioMapper.dtoToUsuario(usuarioDTO);
            usuario = usuarioRepository.save(usuario);
        } catch (Exception e) {
            log.error("Error on create", e.getMessage());
            return null;
        }
        return UsuarioMapper.usuarioToDto(usuario);
    }

    /**
     * Edit a game
     * 
     * @param usuarioDTO the game
     * @param original   the original game
     * @return Boolean true if the game was edited
     */
    public Boolean edit(UsuarioDTO usuarioDTO, UsuarioDTO original) {
        if (original == null) {
            return false;
        }
        try {
            usuarioDTO.setId(original.getId());
            usuarioDTO.setCreatedAt(original.getCreatedAt());
            Usuario usuario = UsuarioMapper.dtoToUsuario(usuarioDTO);
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
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
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error on delete", e.getMessage());
            return false;
        }
        return true;
    }
}
