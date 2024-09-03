package be.zoulou.tennis_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserTennisNotFoundException extends RuntimeException {
    public UserTennisNotFoundException(String message) {
        super(MessageFormat.format("Could not find user with username {0}", message));
    }
}
