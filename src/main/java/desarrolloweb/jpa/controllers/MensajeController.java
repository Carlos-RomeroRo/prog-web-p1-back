package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.db.entities.Mensaje;
import desarrolloweb.jpa.models.db.services.MensajeService;

@RestController
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/messages")
    public List<Mensaje> getAll() {
        return mensajeService.getAll();
    }
    
}
