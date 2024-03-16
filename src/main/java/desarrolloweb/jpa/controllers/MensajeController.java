package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.ResJsonEntity;
import desarrolloweb.jpa.models.db.services.MensajeService;
import desarrolloweb.jpa.models.mappers.dto.MensajeDTO;

@RestController
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/messages")
    public ResponseEntity<ResJsonEntity> getAll() {
        List<MensajeDTO> data = mensajeService.getAll();
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("data", data);
        if (data == null || data.isEmpty()) {
            res.AddDataToRes("message", "There are no messages");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
