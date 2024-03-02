package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.repositories.MensajeRepository;

import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    // get all
    public List<Mensaje> getAll() {
        return mensajeRepository.findAll();
    }

    //get one
    public Mensaje get(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    //create one
    public Mensaje create(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    //edit one
    public Mensaje edit(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    //delete one
    public void delete(Long id) {
        mensajeRepository.deleteById(id);
    }
}
