package desarrolloweb.jpaSpringboot.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpaSpringboot.models.db.entities.Mensaje;
import desarrolloweb.jpaSpringboot.models.db.repositories.MensajeRepository;

import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> obtenerTodosLosMensajes() {
        return mensajeRepository.findAll();
    }
}
