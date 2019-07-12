//package date_time;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Date;

public class Room {

    private int number;
    private HashSet<AbstractCommodity> commoditySet = new HashSet<>();
    private Date maintenanceDates;
    //private ArrayList<Bookings> bookings;

    Room(int number) {
        this.number = number;
        //this.booked = false;
    }

    void setCommoditySet(HashSet<AbstractCommodity> givenCommoditySet){
        this.commoditySet = givenCommoditySet;
    }

    void bookTheRoom() {
        this.booked = true;
    }

    void clearBooking() {
        this.booked = false;
    }

    boolean checkIfBooked() {
        if (!this.booked) {
            return false;
        }
        else return true;
    }

    void prepareCommodities(){
        Iterator<AbstractCommodity> itr = this.commoditySet.iterator();
        for (AbstractCommodity s : this.commoditySet) {
            s.prepare();
        }
        //this.maintenanceDates =
    }

}
