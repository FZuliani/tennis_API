package be.zoulou.tennis_api.model.tabs;


import be.zoulou.tennis_api.model.administrator.UserTennis;
import be.zoulou.tennis_api.model.dto.ReservationDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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


    @ManyToOne
    private TennisCourt tennisCourt;

    @ManyToOne
    private UserTennis userTennis;

    public static Reservation from(ReservationDto reservationDto){
        return Reservation.builder()
                .id(reservationDto.getId())
                .date(reservationDto.getDate())
                .hour(reservationDto.getHour())
                .tennisCourt(TennisCourt.from(reservationDto.getTennisCourt()))
                .userTennis(UserTennis.from(reservationDto.getUserTennis()))
                .build();
    }
}
