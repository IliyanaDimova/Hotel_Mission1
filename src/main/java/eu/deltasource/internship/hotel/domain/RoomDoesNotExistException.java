package eu.deltasource.internship.hotel.domain;

public class RoomDoesNotExistException extends RuntimeException {
    public RoomDoesNotExistException(String message) {
        super(message);
    }
}
