package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.PhotoItem;

public interface PhotoRepository extends CrudRepository<PhotoItem, Integer> {

    // Custom Query Method - Find Photos by Text
    Iterable<PhotoItem> findByTextContaining(String text);

    // Add other custom queries if needed

}
