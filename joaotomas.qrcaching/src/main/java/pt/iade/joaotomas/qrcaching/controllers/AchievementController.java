package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.iade.joaotomas.qrcaching.models.AchievementItem;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.AchievementRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/achievement")
public class AchievementController {

    private static final Logger logger = LoggerFactory.getLogger(AchievementController.class);

    @Autowired
    private AchievementRepository achievementRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AchievementItem> getAchievements() {
        logger.info("Sending all achievements");
        return (List<AchievementItem>) achievementRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAchievement(@PathVariable("id") int id) {
        logger.info("Sending achievement with ID " + id);
        AchievementItem achievement = achievementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Achievement", "id"));

        return ResponseEntity.ok(new Response("Achievement found", achievement));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteAchievement(@PathVariable("id") int id) {
        logger.info("Deleting achievement with ID " + id);
        if (achievementRepository.existsById(id)) {
            achievementRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Achievement deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Achievement not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addAchievement(@RequestBody AchievementItem achievement) {
        logger.info("Including new achievement " + achievement);
        AchievementItem savedAchievement = achievementRepository.save(achievement);
        return ResponseEntity.ok(new Response("Achievement added", savedAchievement));
    }

    // Add other custom queries if needed
}
