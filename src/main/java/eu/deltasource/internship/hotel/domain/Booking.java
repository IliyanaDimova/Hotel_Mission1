package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Booking is a Set in Room. it's fields are:
 * guestId booker's ID (EGN)
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
    public Booking(String guestId, LocalDate from, LocalDate to) {
        this.guestId = guestId;
        this.from = from;
        this.to = to;
    }

    public String getGuestId() {
        return guestId;
    }

    /**
     * Checks if time interval from-to overlaps with Booking's from-to
     *
     * @param from interval's start
     * @param to   interval's end
     * @return true if they overlap, false if not
     */
    public boolean checkIfDatesOverlap(LocalDate from, LocalDate to) {
        if (this.to.isBefore(from) || this.from.isAfter(to)) {
            System.out.println("Dates DON'T overlap!");
            return false;
        } else {
            System.out.println("Dates overlap!");
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Booking))
            return false;
        Booking booking = (Booking) obj;
        return ((booking.from == this.from) && (booking.to == this.to) && (booking.guestId == this.guestId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, from, to);
    }
}
