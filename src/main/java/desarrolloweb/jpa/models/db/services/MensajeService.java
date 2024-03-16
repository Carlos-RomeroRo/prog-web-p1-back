package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.repositories.MensajeRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.MensajeMapper;
import lombok.extern.slf4j.Slf4j;
import desarrolloweb.jpa.models.mappers.dto.MensajeDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all the messages from the database
     * 
     * @return List<MensajeDTO> the list of messages
     */
    public List<MensajeDTO> getAll() {
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream()
                .map(MensajeMapper::mensajeToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a message from the database
     * 
     * @param id the id of the message
     * @return MensajeDTO the message
     */
    public MensajeDTO get(Long id) {
        Mensaje mensaje;
        try {
            mensaje = mensajeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return MensajeMapper.mensajeToDto(mensaje);
    }

    /**
     * Create a new message
     * 
     * @param mensajeDTO the message
     * @return MensajeDTO the created message
     */
    public MensajeDTO create(MensajeDTO mensajeDTO) {
        Mensaje mensaje;
        try {
            mensajeDTO.setCreatedAt(Timestamp.from(java.time.Instant.now()));
            mensaje = MensajeMapper.dtoToMensaje(mensajeDTO, usuarioRepository);
            mensaje = mensajeRepository.save(mensaje);
        } catch (Exception e) {
            log.error("Error on create", e.getMessage());
            return null;
        }
        return MensajeMapper.mensajeToDto(mensaje);
    }

    /**
     * Edit a message
     * 
     * @param mensajeDTO the message
     * @param original the original message
     * @return Boolean true if the message was edited
     */
    public Boolean edit(MensajeDTO mensajeDTO, MensajeDTO original) {
        if (original == null) {
            return false;
        }

        
        Mensaje mensaje;
        try {
            mensajeDTO.setCreatedAt(original.getCreatedAt());
            mensajeDTO.setId(original.getId());
            mensaje = MensajeMapper.dtoToMensaje(mensajeDTO, usuarioRepository);
            mensajeRepository.save(mensaje);
        } catch (Exception e) {
            log.error("Error on edit", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Delete a message
     *
     * @param id the id of the message
     * @return Boolean true if the message was deleted
     */
    public Boolean delete(Long id) {
        try {
            mensajeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error on delete", e.getMessage());
            return false;
        }
        return true;
    }
}
