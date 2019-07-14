import java.util.Date;

public class Booking {
    private String guestName;
    private String guestId;
    private Date from;
    private Date to;

    void Booking(String guestName, String guestId, Date from, Date to){
        this.guestName = guestName;
        this.guestId = guestId;
        this.from = from;
        this.to = to;
    }

    boolean checkIfDatesOverlap(Date from, Date to){
        return  this.from.before(to) && from.before(this.to);
    }
}
