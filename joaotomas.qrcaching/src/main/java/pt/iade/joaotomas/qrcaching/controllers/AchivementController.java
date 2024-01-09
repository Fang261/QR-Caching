package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.joaotomas.qrcaching.models.AchivementI;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.AchivementRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/achivement")
public class AchivementController {

    private static final Logger logger = LoggerFactory.getLogger(AchivementController.class);

    @Autowired
    private AchivementRepository achivementRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AchivementI> getAchivements() {
        logger.info("Sending all achivements");
        return (List<AchivementI>) achivementRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAchivement(@PathVariable("id") int id) {
        logger.info("Sending achivement with ID " + id);
        AchivementI achivement = achivementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Achivement", "id"));

        return ResponseEntity.ok(new Response("Achivement found", achivement));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteAchivement(@PathVariable("id") int id) {
        logger.info("Deleting achivement with ID " + id);
        if (achivementRepository.existsById(id)) {
            achivementRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Achivement deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Achivement not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addAchivement(@RequestBody AchivementI achivement) {
        logger.info("Including new achivement " + achivement);
        AchivementI savedAchivement = achivementRepository.save(achivement);
        return ResponseEntity.ok(new Response("Achivement added", savedAchivement));
    }

    // Add other custom queries if needed
}
