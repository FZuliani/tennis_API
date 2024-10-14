package be.zoulou.tennis_api.service.tabs;


import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.tabs.Reservation;
import be.zoulou.tennis_api.model.tabs.TennisCourt;
import be.zoulou.tennis_api.repository.tabs.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservationByDate(String date) {
        return reservationRepository.findByDate(date);
    }

    public Reservation getReservationByHour(String hour) {
        return reservationRepository.findByHour(hour);
    }

    public Reservation getReservationByTennisCourtId(Long tennisCourtId) {
        return reservationRepository.findByTennisCourtId(tennisCourtId);
    }

    public Reservation getReservationByUserTennisId(Long userTennisID) {
        return reservationRepository.findByUserTennisId(userTennisID);
    }

    public boolean addReservation(Reservation reservation) {
        //check if the reservation is already taken
        Reservation reservation1 = reservationRepository.findByDateAndHourAndTennisCourtId(reservation.getDate(), reservation.getHour(), reservation.getTennisCourtId());
        if (reservation1 != null) {
            return false;
        }
        reservationRepository.save(reservation);
        return true;
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

}
