package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
