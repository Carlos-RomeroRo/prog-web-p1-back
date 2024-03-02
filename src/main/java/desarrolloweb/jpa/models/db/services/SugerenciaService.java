package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.jpa.models.db.repositories.SugerenciaRepository;

import java.util.List;

@Service
public class SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    public List<Sugerencia> getAll() {
        return sugerenciaRepository.findAll();
    }

    public Sugerencia get(Long id) {
        return sugerenciaRepository.findById(id).orElse(null);
    }

    public Sugerencia create(Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }

    public Sugerencia edit(Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }

    public void delete(Long id) {
        sugerenciaRepository.deleteById(id);
    }
}
