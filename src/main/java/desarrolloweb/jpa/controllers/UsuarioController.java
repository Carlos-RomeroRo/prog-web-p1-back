package desarrolloweb.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.db.entities.Usuario;
import desarrolloweb.jpa.models.db.services.UsuarioService;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    public List<Usuario> getAllUsers() {
        return usuarioService.getAll();
    }
}
