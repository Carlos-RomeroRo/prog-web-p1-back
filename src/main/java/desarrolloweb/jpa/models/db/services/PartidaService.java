package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.repositories.PartidaRepository;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> obtenerTodasLasPartidas() {
        return partidaRepository.findAll();
    }
}
