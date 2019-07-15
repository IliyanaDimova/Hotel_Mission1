import java.text.ParseException;
import java.util.HashSet;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Room {

    private int number;
    private HashSet<AbstractCommodity> commoditySet;
    private HashSet<Date> maintenanceDates;
    private HashSet<Booking> bookings;

    Room() {
    }

    Room(int number) {
        this.number = number;
    }

    int getNumber(){
        return this.number;
    }

    void setCommoditySet(HashSet<AbstractCommodity> givenCommoditySet){
        this.commoditySet = givenCommoditySet;
    }

    Date stringToDate(String stringDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        try {

            Date date = formatter.parse(stringDate);
            return date;

        } catch (ParseException e) {
            System.out.println("Parse throws exception");
            return null;
        }

    }

    //Prepares commodities in a room & adds a maintenance record through string
    void prepareCommodities(Date date) {
        for (AbstractCommodity s : this.commoditySet) {
            s.prepare();
        }
        this.maintenanceDates.add(date);
    }

    void createBooking(String guestName, String guestId, Date from, Date to){
        Booking booking = new Booking();
        booking.Booking(guestName, guestId, from, to);
        this.bookings.add(booking);
    }

    void removeBooking(String guestName, String guestId, Date from, Date to){
        Booking booking = new Booking();
        booking.Booking(guestName, guestId, from, to);
        this.bookings.remove(booking);
    }

    //Returns room that are unbooked for the time period & have at least the min number of beds
    //this returned rooms will be added to arraylist and checked for the best match of beds
    boolean findIfAvailableForIntervalAndSize(Date from, Date to, int numberOfPeople){
        int ovelapCount = 0;
        int possibleSleepingPlaces = 0;

        for (Booking s : this.bookings) {
            if(s.checkIfDatesOverlap(from, to)){
                ovelapCount++;
            }
        }

        for (AbstractCommodity s : this.commoditySet) {
            possibleSleepingPlaces += s.getNumberOfPersonasPerBed();
        }

        if((possibleSleepingPlaces >= numberOfPeople) && (ovelapCount == 0)){
            return true;
        }
        else return false;
    }

    int getNumberOfTwoPersonaBeds(){
        int number = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if(s.getNumberOfPersonasPerBed()==2) {
                number++;
            }
        }
        return number;
    }

    int getNumberOfOnePersonaBeds(){
        int number = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if(s.getNumberOfPersonasPerBed()==1) {
                number++;
            }
        }
        return number;
    }

    boolean IsAPerfectMatchRoom(int personas){
        int numberOfPersonasCount = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if(s.getNumberOfPersonasPerBed()>0) {
                numberOfPersonasCount++;
            }
        }
        if(numberOfPersonasCount==personas){
            return true;
        }
        else return false;
    }

    boolean bookRoomForInterval(String stringFrom, String stringTo, String guestName, String guestId) {
        Date from = stringToDate(stringFrom);
        Date to = stringToDate(stringTo);
        if(from==null || to==null){
            System.out.println("String didn't convert to Date");
            return false;
        }
        this.createBooking(guestName, guestId, from, to);
        this.prepareCommodities(from);
        return true;
    }

}
