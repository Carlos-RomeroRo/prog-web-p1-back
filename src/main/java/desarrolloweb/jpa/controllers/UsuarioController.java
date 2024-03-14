package desarrolloweb.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.ResJsonEntity;
import desarrolloweb.jpa.models.db.services.UsuarioService;
import desarrolloweb.jpa.models.mappers.dto.UsuarioDTO;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    public ResponseEntity<ResJsonEntity> getAllUsers() {
        List<UsuarioDTO> data = usuarioService.getAll();
        ResJsonEntity res = new ResJsonEntity();
        if (data != null && !data.isEmpty()) {
            res.AddDataToRes("data", data);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }else{
            res.AddDataToRes("message", "There are no users");
            res.AddDataToRes("data", data);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }
}
