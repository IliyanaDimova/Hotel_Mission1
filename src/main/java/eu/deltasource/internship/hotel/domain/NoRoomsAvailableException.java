package eu.deltasource.internship.hotel.domain;

//todo add JavaDoc
public class NoRoomsAvailableException extends RuntimeException {

    NoRoomsAvailableException(String message){
        super(message);
    }
}
