package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.EventItem;

import java.time.LocalDate;

public interface EventRepository extends CrudRepository<EventItem, Integer> {

    // Custom Query Method - Find Events by Name
    Iterable<EventItem> findByName(String name);

    // Custom Query Method - Find Events by Date Range
    Iterable<EventItem> findByInicialDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom Query Method - Find Events by Location
    Iterable<EventItem> findByLatitudeBetweenAndLongitudeBetween(float minLat, float maxLat, float minLong, float maxLong);

    // Custom Query Method - Find Events by Name and Date Range
    Iterable<EventItem> findByNameContainingAndInicialDateBetween(String name, LocalDate startDate, LocalDate endDate);

    // Custom Query Method - Find Events Ordered by Date
    Iterable<EventItem> findAllByOrderByInicialDateAsc();

    // Find events associated with a specific qrcode
    Iterable<EventItem> findByLqe_Lqrcode_Id(int qrcodeId);

}
