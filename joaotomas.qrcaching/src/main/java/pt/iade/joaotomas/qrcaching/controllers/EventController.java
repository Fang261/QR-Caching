package pt.iade.joaotomas.qrcaching.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.iade.joaotomas.qrcaching.models.EventItem;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.EventRepository;


@RestController
@RequestMapping(path = "/event")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventItem> getEvents() {
        logger.info("Sending all events");
        return EventRepository.getEvents(); // Assuming you have an EventRepository class to handle events
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventItem getEvent(@PathVariable("id") int id)
            throws NotFoundException {
        logger.info("Sending event with ID " + id);
        EventItem event = EventRepository.getEvent(id); // Assuming you have a method like getEvent in EventRepository
        if (event != null)
            return event;
        else
            throw new NotFoundException("" + id, "Event", "id");
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEvent(@PathVariable("id") int id) {
        logger.info("Deleting event with ID " + id);
        if (EventRepository.deleteEvent(id)) // Assuming you have a method like deleteEvent in EventRepository
            return new Response(id + " was deleted.", null);
        else
            return new Response(id + " not found.", null);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventItem addEvent(@RequestBody EventItem event) {
        logger.info("Including new event " + event);
        EventRepository.addEvent(event); // Assuming you have a method like addEvent in EventRepository
        return event;
    }

    
    
}
