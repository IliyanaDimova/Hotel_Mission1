import java.time.LocalDate;

/**
 * Class Booking is a Set of Booking in Room Class. it's fields are:
 * guestName booker's name
 * guestId booker's ID
 * LocalDate from which booking starts
 * LocalDate to which booking ends
 */
public class Booking {
    private String guestName;
    private String guestId;
    private LocalDate from;
    private LocalDate to;

    Booking(String guestName, String guestId, LocalDate from, LocalDate to) {
        this.guestName = guestName;
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
