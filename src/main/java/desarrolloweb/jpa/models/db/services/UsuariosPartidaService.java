package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.jpa.models.db.repositories.UsuariosPartidaRepository;

import java.util.List;

@Service
public class UsuariosPartidaService {

    @Autowired
    private UsuariosPartidaRepository usuariosPartidaRepository;

    public List<UsuarioPartida> getAll() {
        return usuariosPartidaRepository.findAll();
    }

    public UsuarioPartida get(Long id) {
        return usuariosPartidaRepository.findById(id).orElse(null);
    }

    public void create(UsuarioPartida usuarioPartida) {
        usuariosPartidaRepository.save(usuarioPartida);
    }

    public void edit(UsuarioPartida usuarioPartida) {
        usuariosPartidaRepository.save(usuarioPartida);
    }

    public void delete(Long id) {
        usuariosPartidaRepository.deleteById(id);
    }
}
