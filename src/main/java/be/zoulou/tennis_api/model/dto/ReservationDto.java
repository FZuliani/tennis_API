package be.zoulou.tennis_api.model.dto;

import be.zoulou.tennis_api.model.tabs.Reservation;
import lombok.Data;

@Data
public class ReservationDto {

        private Long id;
        private String date;
        private String Hour;
        private TennisCourtDto tennisCourt;
        private UserTennisDto userTennis;

        public static ReservationDto from (Reservation reservation){
            if (reservation == null){
                return null;
            }
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setId(reservation.getId());
            reservationDto.setDate(reservation.getDate());
            reservationDto.setHour(reservation.getHour());
            reservationDto.setTennisCourt(TennisCourtDto.from(reservation.getTennisCourt()));
            reservationDto.setUserTennis(UserTennisDto.from(reservation.getUserTennis()));
            return reservationDto;
        }
}
