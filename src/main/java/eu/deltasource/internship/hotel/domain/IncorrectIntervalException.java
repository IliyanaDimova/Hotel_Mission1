package eu.deltasource.internship.hotel.domain;

/**
 * It is thrown in Manager if Date from starts after teh Date to
 */
public class IncorrectIntervalException extends RuntimeException {
    public IncorrectIntervalException(String message) {
        super(message);
    }
}
