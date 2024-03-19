package desarrolloweb.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.ResJsonEntity;
import desarrolloweb.jpa.models.db.services.UsuarioService;
import desarrolloweb.jpa.models.mappers.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/users")
    public ResponseEntity<ResJsonEntity> getAllUsers() {
        List<UsuarioDTO> data = usuarioService.getAll();
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("data", data);
        if (data == null || data.isEmpty()) {
            res.AddMessageToRes( "There are no users");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
