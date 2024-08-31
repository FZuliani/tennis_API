package be.zoulou.tennis_api.security.security.repository;

import be.zoulou.tennis_api.security.security.entity.UserTennis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserTennis, Long> {

    UserTennis findByUserName(String username);
}
