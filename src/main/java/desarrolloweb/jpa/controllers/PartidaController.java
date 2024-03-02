package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.db.entities.Partida;
import desarrolloweb.jpa.models.db.services.PartidaService;



@RestController
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @GetMapping("/games")
    public List<Partida> getAll() {
        return partidaService.getAll();
    }
    
}
