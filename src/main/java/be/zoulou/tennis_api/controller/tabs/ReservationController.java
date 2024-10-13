package be.zoulou.tennis_api.controller.tabs;


import be.zoulou.tennis_api.model.dto.ReservationDto;
import be.zoulou.tennis_api.model.tabs.Reservation;
import be.zoulou.tennis_api.service.administrator.UserTennisService;
import be.zoulou.tennis_api.service.tabs.ReservationService;
import be.zoulou.tennis_api.service.tabs.TennisCourtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<Iterable<ReservationDto>> getReservations(){
        List<Reservation> reservations = reservationService.getReservations();

        Iterable<ReservationDto> reservationDtos = reservations.stream()
                .map(ReservationDto::from)
                .toList();

        return ResponseEntity.ok(reservationDtos);
    }

    @GetMapping("/reservation/date/{date}")
    public ResponseEntity<ReservationDto> getReservationByDate(String date){
        Reservation reservation = reservationService.getReservationByDate(date);
        return ResponseEntity.ok(ReservationDto.from(reservation));
    }

    @GetMapping("/reservation/hour/{hour}")
    public ResponseEntity<ReservationDto> getReservationByHour(String hour){
        Reservation reservation = reservationService.getReservationByHour(hour);
        return ResponseEntity.ok(ReservationDto.from(reservation));
    }

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody final ReservationDto reservationDto){

        Reservation reservation = reservationService.addReservation(Reservation.from(reservationDto));
        return ResponseEntity.ok(ReservationDto.from(reservation));
    }

}
