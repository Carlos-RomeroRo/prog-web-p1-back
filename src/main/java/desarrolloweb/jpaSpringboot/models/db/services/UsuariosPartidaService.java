package desarrolloweb.jpaSpringboot.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpaSpringboot.models.db.entities.UsuarioPartida;
import desarrolloweb.jpaSpringboot.models.db.repositories.UsuariosPartidaRepository;

import java.util.List;

@Service
public class UsuariosPartidaService {

    @Autowired
    private UsuariosPartidaRepository usuariosPartidaRepository;

    public List<UsuarioPartida> obtenerTodosLosUsuariosPartidas() {
        return usuariosPartidaRepository.findAll();
    }
}
