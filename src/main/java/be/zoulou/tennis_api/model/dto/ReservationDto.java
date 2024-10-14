package be.zoulou.tennis_api.model.dto;

import be.zoulou.tennis_api.model.tabs.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class ReservationDto {

        private Long id;
        private String date;
        private String Hour;
        private Long tennisCourtId;
        private Long userTennisId;

        public static ReservationDto from (Reservation reservation){
            if (reservation == null){
                return null;
            }
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setId(reservation.getId());
            reservationDto.setDate(reservation.getDate());
            reservationDto.setHour(reservation.getHour());

            return reservationDto;
        }
}
