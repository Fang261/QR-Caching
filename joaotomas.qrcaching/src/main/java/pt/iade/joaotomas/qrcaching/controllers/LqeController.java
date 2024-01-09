package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.iade.joaotomas.qrcaching.models.Lqe;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.LqeRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/lqe")
public class LqeController {

    private static final Logger logger = LoggerFactory.getLogger(LqeController.class);

    @Autowired
    private LqeRepository lqeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Lqe> getAllLqes() {
        logger.info("Sending all Lqes");
        return (List<Lqe>) lqeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getLqe(@PathVariable("id") int id) {
        logger.info("Sending Lqe with ID " + id);
        Lqe lqe = lqeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Lqe", "id"));

        return ResponseEntity.ok(new Response("Lqe found", lqe));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteLqe(@PathVariable("id") int id) {
        logger.info("Deleting Lqe with ID " + id);
        if (lqeRepository.existsById(id)) {
            lqeRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Lqe deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Lqe not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addLqe(@RequestBody Lqe lqe) {
        logger.info("Including new Lqe " + lqe);
        Lqe savedLqe = lqeRepository.save(lqe);
        return ResponseEntity.ok(new Response("Lqe added", savedLqe));
    }

    // Add other custom queries if needed
}
