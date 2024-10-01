package be.zoulou.tennis_api.repository.administrator;

import be.zoulou.tennis_api.model.administrator.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
