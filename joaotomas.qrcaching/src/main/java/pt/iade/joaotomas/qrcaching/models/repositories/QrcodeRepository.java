package pt.iade.joaotomas.qrcaching.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.QrcodeItem;

public interface QrcodeRepository extends CrudRepository<QrcodeItem, Integer> {
    // Find all qrcodes that are not associated with any event
    Iterable<QrcodeItem> findByEventsIsNull();

    // Find all qrcodes associated with a specific event
    Iterable<QrcodeItem> findByEventsId(int eventId);

    // Find qrcode by its unique code
    Optional<QrcodeItem> findByQrcode(String qrcode);

}
