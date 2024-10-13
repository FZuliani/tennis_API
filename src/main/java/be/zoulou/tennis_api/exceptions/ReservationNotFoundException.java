package be.zoulou.tennis_api.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Reservation not found")
public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
      super(MessageFormat.format("Could not find reservation with id {0}", message));
    }
}