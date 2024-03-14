package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.repositories.MensajeRepository;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.MensajeMapper;
import desarrolloweb.jpa.models.mappers.dto.MensajeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<MensajeDTO> getAll() {
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream()
                .map(MensajeMapper::mensajeToDto)
                .collect(Collectors.toList());
    }

    public MensajeDTO get(Long id) {
        Mensaje mensaje = mensajeRepository.findById(id).orElse(null);
        if (mensaje == null) {
            return null;
        }
        return MensajeMapper.mensajeToDto(mensaje);
    }

    public MensajeDTO create(MensajeDTO mensajeDTO) {
        Mensaje mensaje = MensajeMapper.dtoToMensaje(mensajeDTO, usuarioRepository);
        mensaje = mensajeRepository.save(mensaje);
        return MensajeMapper.mensajeToDto(mensaje);
    }

    public MensajeDTO edit(MensajeDTO mensajeDTO) {
        Mensaje mensaje = MensajeMapper.dtoToMensaje(mensajeDTO, usuarioRepository);
        mensaje = mensajeRepository.save(mensaje);
        return MensajeMapper.mensajeToDto(mensaje);
    }

    public void delete(Long id) {
        mensajeRepository.deleteById(id);
    }
}
