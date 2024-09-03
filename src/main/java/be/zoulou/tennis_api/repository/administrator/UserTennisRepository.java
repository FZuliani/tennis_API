package be.zoulou.tennis_api.repository.administrator;

import be.zoulou.tennis_api.model.administrator.UserTennis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTennisRepository extends CrudRepository<UserTennis, Long> {

    UserTennis findByUsername(final String username);
    UserTennis findByEmail(final String email);

}
