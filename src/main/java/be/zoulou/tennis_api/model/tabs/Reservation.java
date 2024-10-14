package be.zoulou.tennis_api.model.tabs;


import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.dto.ReservationDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reservation")
public class Reservation {

    @Getter
    @Setter
    @Id
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String date;

    @Getter
    @Setter
    @Column(nullable = false)
    private String hour;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long tennisCourtId;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long userTennisId;

    public static Reservation from(ReservationDto reservationDto){
        return Reservation.builder()
                .id(reservationDto.getId())
                .date(reservationDto.getDate())
                .hour(reservationDto.getHour())
                .tennisCourtId(reservationDto.getTennisCourtId())
                .userTennisId(reservationDto.getUserTennisId())
                .build();
    }
}
