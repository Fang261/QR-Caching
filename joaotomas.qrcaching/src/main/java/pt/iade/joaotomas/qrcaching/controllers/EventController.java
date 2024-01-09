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

import pt.iade.joaotomas.qrcaching.models.Event;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.EventRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;


import java.util.List;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getEvents() {
        logger.info("Sending all events");
        return (List<Event>) eventRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getEvent(@PathVariable("id") int id) {
        logger.info("Sending event with ID " + id);
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Event", "id"));

        return ResponseEntity.ok(new Response("Event found", event));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteEvent(@PathVariable("id") int id) {
        logger.info("Deleting event with ID " + id);
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Event deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Event not found", null));
        }
    }

    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addEvent(@RequestBody Event event) {
        logger.info("Including new event " + event);
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.ok(new Response("Event added", savedEvent));
    }
    
    // Add other custom queries if needed

}
