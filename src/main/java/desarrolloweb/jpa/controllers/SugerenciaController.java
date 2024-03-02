package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.jpa.models.db.services.SugerenciaService;


@RestController
public class SugerenciaController {

    @Autowired
    private SugerenciaService service;

    @GetMapping("/suggestions")
    public List<Sugerencia> getAll() {
        return service.getAll();
    }
    
}
