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

    public List<Partida> getAll() {
        return partidaRepository.findAll();
    }

    public Partida get(Long id) {
        return partidaRepository.findById(id).orElse(null);
    }

    public Partida create(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida edit(Partida partida) {
        return partidaRepository.save(partida);
    }

    public void delete(Long id) {
        partidaRepository.deleteById(id);
    }
}
