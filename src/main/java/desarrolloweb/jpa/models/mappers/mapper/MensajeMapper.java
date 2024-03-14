package desarrolloweb.jpa.models.mappers.mapper;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.dto.MensajeDTO;

public class MensajeMapper {

    public static MensajeDTO mensajeToDto(Mensaje mensaje) {
        MensajeDTO dto = new MensajeDTO();
        dto.setId(mensaje.getId());
        dto.setCreadorEmail(mensaje.getCreador().getEmail());
        dto.setDestinatarioEmail(mensaje.getDestinatario().getEmail());
        dto.setCreatedAt(mensaje.getCreated_at());
        dto.setContenido(mensaje.getContenido());
        return dto;
    }

    public static Mensaje dtoToMensaje(MensajeDTO dto, UsuarioRepository usuarioRepository) {
        Mensaje mensaje = new Mensaje();
        mensaje.setId(dto.getId());
        mensaje.setCreador(usuarioRepository.findByEmail(dto.getCreadorEmail()));
        mensaje.setDestinatario(usuarioRepository.findByEmail(dto.getDestinatarioEmail()));
        mensaje.setCreated_at(dto.getCreatedAt());
        mensaje.setContenido(dto.getContenido());
        return mensaje;
    }
}
