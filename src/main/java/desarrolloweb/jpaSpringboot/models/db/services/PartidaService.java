package desarrolloweb.jpaSpringboot.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpaSpringboot.models.db.entities.Partida;
import desarrolloweb.jpaSpringboot.models.db.repositories.PartidaRepository;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> obtenerTodasLasPartidas() {
        return partidaRepository.findAll();
    }
}
