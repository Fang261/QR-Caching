package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.iade.joaotomas.qrcaching.models.Ulq;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.UlqRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/ulq")
public class UlqController {

    private static final Logger logger = LoggerFactory.getLogger(UlqController.class);

    @Autowired
    private UlqRepository ulqRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ulq> getAllUlqs() {
        logger.info("Sending all Ulqs");
        return (List<Ulq>) ulqRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getUlq(@PathVariable("id") int id) {
        logger.info("Sending Ulq with ID " + id);
        Ulq ulq = ulqRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Ulq", "id"));

        return ResponseEntity.ok(new Response("Ulq found", ulq));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteUlq(@PathVariable("id") int id) {
        logger.info("Deleting Ulq with ID " + id);
        if (ulqRepository.existsById(id)) {
            ulqRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Ulq deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Ulq not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addUlq(@RequestBody Ulq ulq) {
        logger.info("Including new Ulq " + ulq);
        Ulq savedUlq = ulqRepository.save(ulq);
        return ResponseEntity.ok(new Response("Ulq added", savedUlq));
    }

    // Add other custom queries if needed
}
