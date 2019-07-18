package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;

/** //todo clean up javadoc {main.java.eu.deltasource.internship.hotel.domain}
 * Class main.java.eu.deltasource.internship.hotel.domain.Booking is a Set of main.java.eu.deltasource.internship.hotel.domain.Booking in main.java.eu.deltasource.internship.hotel.domain.Room Class. it's fields are:
 * guestName booker's name
 * guestId booker's ID
 * LocalDate from which booking starts
 * LocalDate to which booking ends
 */
public class Booking {
    private String guestId; //todo this is not being used
    private LocalDate from;
    private LocalDate to;

    /**
     * Booking constructor
     *
     * @param guestId the EGN of the guest
     * @param from    date from which the guest want to book
     * @param to      date to which the guest want to book
     */
    Booking(String guestId, LocalDate from, LocalDate to) {
        this.guestId = guestId;
        this.from = from;
        this.to = to;
    }

    /**
     * Checks if time intervals overlap
     *
     * @param from interval's start
     * @param to   interval's end
     * @return true if they overlap, false if not
     */
    public boolean checkIfDatesOverlap(LocalDate from, LocalDate to) {
        return ((this.from.isBefore(to)) && (this.to.isAfter(from)));
    }
}
