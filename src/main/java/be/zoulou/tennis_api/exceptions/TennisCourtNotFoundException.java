package be.zoulou.tennis_api.exceptions;

public class TennisCourtNotFoundException extends RuntimeException {
    public TennisCourtNotFoundException(String message) {
        super(message);
    }
}
