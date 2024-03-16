package desarrolloweb.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.ResJsonEntity;
import desarrolloweb.jpa.models.db.services.MensajeService;
import desarrolloweb.jpa.models.mappers.dto.MensajeDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    public static final String MESSAGE_NOT_FOUND = "There is no message with that id";
    public static final String NO_MESSAGES = "There are no messages";
    public static final String MESSAGE_NOT_CREATED = "The message could not be created";
    public static final String MESSAGE_NOT_UPDATED = "The message could not be updated";

    // CRUD Get (read)
    @GetMapping("/messages")
    public ResponseEntity<ResJsonEntity> getAll() {
        List<MensajeDTO> data = mensajeService.getAll();
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("data", data);
        if (data == null || data.isEmpty()) {
            res.AddMessageToRes(NO_MESSAGES);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // CRUD Get (read by id)
    @GetMapping("/messages/{id}")
    public ResponseEntity<ResJsonEntity> get(@PathVariable("id") Long id) {
        MensajeDTO data = mensajeService.get(id);
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("data", data);
        if (data == null) {
            res.AddMessageToRes(MESSAGE_NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // CRUD Delete
    @DeleteMapping("/messages/{id}/delete")
    public ResponseEntity<ResJsonEntity> delete(@PathVariable("id") Long id) {
        boolean deleted = mensajeService.delete(id);
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("deleted", deleted);
        if (!deleted) {
            res.AddMessageToRes(MESSAGE_NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // CRUD Update
    @PutMapping("/messages/{id}/update")
    public ResponseEntity<ResJsonEntity> update(@PathVariable("id") Long id, @RequestBody MensajeDTO body) {
        // check if the message exists
        MensajeDTO message = mensajeService.get(id);
        if (message == null) {
            ResJsonEntity res = new ResJsonEntity();
            res.AddMessageToRes(MESSAGE_NOT_FOUND);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        // update the message
        boolean updated = mensajeService.edit(body);
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("updated", updated);
        if (!updated) {
            res.AddMessageToRes(MESSAGE_NOT_UPDATED);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // CRUD Create
    @PostMapping("/messages/create")
    public ResponseEntity<ResJsonEntity> create(@RequestBody MensajeDTO body) {
        MensajeDTO created = mensajeService.create(body);
        ResJsonEntity res = new ResJsonEntity();
        res.AddDataToRes("created", created);
        if (created == null) {
            res.AddMessageToRes(MESSAGE_NOT_CREATED);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
