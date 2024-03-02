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

    public List<Sugerencia> obtenerTodasLasSugerencias() {
        return sugerenciaRepository.findAll();
    }
}
