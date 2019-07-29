package eu.deltasource.internship.hotel.domain;

/**
 * Custom RunTime Exception
 * It is thrown in Manager when there is no perfect fit room in createBooking()
 */
public class NoRoomsAvailableException extends RuntimeException {

    NoRoomsAvailableException(String message) {
        super(message);
    }
}
