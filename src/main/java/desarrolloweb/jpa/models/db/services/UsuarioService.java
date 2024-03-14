package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.jpa.models.db.repositories.UsuarioRepository;
import desarrolloweb.jpa.models.mappers.mapper.UsuarioMapper;
import desarrolloweb.jpa.models.mappers.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::usuarioToDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO get(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        return UsuarioMapper.usuarioToDto(usuario);
    }

    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            return null;
        }
        return UsuarioMapper.usuarioToDto(usuario);
    }

    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.dtoToUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.usuarioToDto(usuario);
    }

    public Boolean edit(UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = UsuarioMapper.dtoToUsuario(usuarioDTO);
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
