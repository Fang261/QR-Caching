package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.joaotomas.qrcaching.models.AchievementItem;

public interface AchievementRepository extends CrudRepository<AchievementItem, Integer> {
    // Find achievements associated with a specific qrcode event
    Iterable<AchievementItem> findByLqe_Lqrcode_Id(int qrcodeId);

}
