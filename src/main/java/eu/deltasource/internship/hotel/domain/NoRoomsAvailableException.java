package eu.deltasource.internship.hotel.domain;

/**
 * Custom RunTime Exception
 * It is thrown in classManager when there is no perfect fit room
 */
public class NoRoomsAvailableException extends RuntimeException {

    NoRoomsAvailableException(String message){
        super(message);
    }
}
