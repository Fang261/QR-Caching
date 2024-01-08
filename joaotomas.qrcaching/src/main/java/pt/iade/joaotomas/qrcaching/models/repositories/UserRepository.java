package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.UserItem;

public interface UserRepository extends CrudRepository<UserItem, Integer> {
    // Find a user's completed qrcodes
    Iterable<UserItem> findByCompletedQrcodes_Qrcode(String qrcode);

    // Find a user's achievements
    Iterable<UserItem> findByAchievements_Id(int achievementId);

}
