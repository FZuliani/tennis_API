package be.zoulou.tennis_api.repository.tabs;

import be.zoulou.tennis_api.model.tabs.TennisCourt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisCourtRepository extends CrudRepository<TennisCourt, Long> {
    TennisCourt findByIsIndoor(boolean type);
}