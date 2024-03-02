package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.db.entities.UsuarioPartida;
import desarrolloweb.jpa.models.db.services.UsuariosPartidaService;


@RestController
public class UsuarioPartidaController {

    @Autowired
    private UsuariosPartidaService usuariosPartidaService;

    @GetMapping("/user-games")
    public List<UsuarioPartida> getAll() {
        return usuariosPartidaService.getAll();
    }
    
}
