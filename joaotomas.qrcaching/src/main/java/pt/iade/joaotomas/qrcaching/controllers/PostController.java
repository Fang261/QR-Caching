package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.joaotomas.qrcaching.models.Post;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.PostRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/photo")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostRepository photoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getAllPhotos() {
        logger.info("Sending all photos");
        return (List<Post>) photoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getPhoto(@PathVariable("id") int id) {
        logger.info("Sending photo with ID " + id);
        Post photo = photoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Photo", "id"));

        return ResponseEntity.ok(new Response("Photo found", photo));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deletePhoto(@PathVariable("id") int id) {
        logger.info("Deleting photo with ID " + id);
        if (photoRepository.existsById(id)) {
            photoRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Photo deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Photo not found", null));
        }
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addPhoto(@RequestBody Post photo) {
        logger.info("Including new photo " + photo);
        Post savedPhoto = photoRepository.save(photo);
        return ResponseEntity.ok(new Response("Photo added", savedPhoto));
    }

    // Add other custom queries if needed
}
