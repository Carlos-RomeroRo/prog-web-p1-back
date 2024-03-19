package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.ResJsonEntity;
import desarrolloweb.jpa.models.db.services.UsuariosPartidaService;
import desarrolloweb.jpa.models.mappers.dto.UsuarioPartidaDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UsuarioPartidaController {

    @Autowired
    private UsuariosPartidaService usuariosPartidaService;

    @GetMapping("/user-games")
    public ResponseEntity<ResJsonEntity> getAll() {
        List<UsuarioPartidaDTO> data = usuariosPartidaService.getAll();
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("data", data);
        if (data == null || data.isEmpty()) {
            res.AddMessageToRes( "There are no games");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
