package be.zoulou.tennis_api.repository.tabs;


import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.tabs.Reservation;
import be.zoulou.tennis_api.model.tabs.TennisCourt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation findByDate(String date);
    Reservation findByHour(String hour);
    Reservation findByTennisCourtId(Long tennisCourtId);
    Reservation findByUserTennisId(Long userTennisID);
}
