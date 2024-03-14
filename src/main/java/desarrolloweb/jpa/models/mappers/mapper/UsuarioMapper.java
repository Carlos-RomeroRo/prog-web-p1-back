package desarrolloweb.jpa.models.mappers.mapper;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.jpa.models.mappers.dto.UsuarioDTO;

public class UsuarioMapper {

    public static UsuarioDTO usuarioToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setNombre(usuario.getNombre());
        dto.setApellidos(usuario.getApellidos());
        dto.setEdad(usuario.getEdad());
        dto.setPassword(usuario.getPassword());
        dto.setRepPassword(usuario.getRep_password());
        dto.setEnabled(usuario.getEnabled());
        dto.setFoto(usuario.getFoto());
        dto.setRol(usuario.getRol());
        dto.setCreatedAt(usuario.getCreated_at());
        return dto;
    }

    public static Usuario dtoToUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEdad(dto.getEdad());
        usuario.setPassword(dto.getPassword());
        usuario.setRep_password(dto.getRepPassword());
        usuario.setEnabled(dto.getEnabled());
        usuario.setFoto(dto.getFoto());
        usuario.setRol(dto.getRol());
        usuario.setCreated_at(dto.getCreatedAt());
        return usuario;
    }
}
