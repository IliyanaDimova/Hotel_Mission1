import java.time.LocalDate;

public class Booking {
    private String guestName;
    private String guestId;
    private LocalDate from;
    private LocalDate to;

    void Booking(String guestName, String guestId, LocalDate from, LocalDate to) {
        this.guestName = guestName;
        this.guestId = guestId;
        this.from = from;
        this.to = to;
    }

    public boolean checkIfDatesOverlap(LocalDate from, LocalDate to) {
        return (this.from.isBefore(to) && from.isBefore(this.to));
    }
}
