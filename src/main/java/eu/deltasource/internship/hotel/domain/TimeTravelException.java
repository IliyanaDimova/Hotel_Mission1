package eu.deltasource.internship.hotel.domain;

/**
 * This exceprion is thrown in Room createBooking() if the booking date starts before today's date
 */
public class TimeTravelException extends RuntimeException {

    public TimeTravelException(String message){
        super(message);
    }
}
