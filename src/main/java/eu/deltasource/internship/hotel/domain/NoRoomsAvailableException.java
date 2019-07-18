package eu.deltasource.internship.hotel.domain;

/**
 * Custom RunTime Exception
 */
public class NoRoomsAvailableException extends RuntimeException {

    NoRoomsAvailableException(String message){
        super(message);
    }
}
