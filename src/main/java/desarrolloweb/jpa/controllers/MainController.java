package desarrolloweb.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrolloweb.jpa.models.api.Message;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
    @GetMapping("/")
    public ResponseEntity<Message> hello(HttpServletRequest request) {
        log.info("request: " + request.getRequestURL());
        return new ResponseEntity<>(new Message("Welcome to the ProgWebP1!"), HttpStatus.OK);
    }
}
