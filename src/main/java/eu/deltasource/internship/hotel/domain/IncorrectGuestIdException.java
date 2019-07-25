package eu.deltasource.internship.hotel.domain;

public class IncorrectGuestIdException extends RuntimeException {
    public IncorrectGuestIdException(String message) {
        super(message);
    }
}
