package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Booking in Room Class. it's fields are:
 * guestName booker's name
 * guestId booker's ID
 * LocalDate from which booking starts
 * LocalDate to which booking ends
 */
public class Booking {
    private String guestId;
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
        if(this.to.isBefore(from)||this.from.isAfter(to)){
            System.out.println("Dates DON'T overlap!");
            return false;
        }
        else{
            System.out.println("Dates overlap!");
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Booking))
            return false;
        Booking booking = (Booking) obj;
        return ((booking.from == this.from)&&(booking.to == this.to)&&(booking.guestId == this.guestId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, from, to);
    }
}
