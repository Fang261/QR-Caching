package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.iade.joaotomas.qrcaching.models.Achlqe;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.AchlqeRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/achlqe")
public class AchlqeController {

    private static final Logger logger = LoggerFactory.getLogger(AchlqeController.class);

    @Autowired
    private AchlqeRepository achlqeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Achlqe> getAllAchlqes() {
        logger.info("Sending all Achlqes");
        return (List<Achlqe>) achlqeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAchlqe(@PathVariable("id") int id) {
        logger.info("Sending Achlqe with ID " + id);
        Achlqe achlqe = achlqeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Achlqe", "id"));

        return ResponseEntity.ok(new Response("Achlqe found", achlqe));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteAchlqe(@PathVariable("id") int id) {
        logger.info("Deleting Achlqe with ID " + id);
        if (achlqeRepository.existsById(id)) {
            achlqeRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Achlqe deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Achlqe not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addAchlqe(@RequestBody Achlqe achlqe) {
        logger.info("Including new Achlqe " + achlqe);
        Achlqe savedAchlqe = achlqeRepository.save(achlqe);
        return ResponseEntity.ok(new Response("Achlqe added", savedAchlqe));
    }

    // Add other custom queries if needed
}
