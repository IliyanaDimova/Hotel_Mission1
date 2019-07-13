import java.text.ParseException;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Room {

    private int number;
    private HashSet<AbstractCommodity> commoditySet;
    private HashSet<Date> maintenanceDates;
    private HashSet<Booking> bookings;

    Room(int number) {
        this.number = number;
        //this.booked = false;
    }

    int getNumber(){
        return this.number;
    }

    void setCommoditySet(HashSet<AbstractCommodity> givenCommoditySet){
        this.commoditySet = givenCommoditySet;
    }

    //Prepares commodities in a room & adds a maintenance record through string
    void prepareCommodities(String date) throws ParseException {
        //Iterator<AbstractCommodity> itr = this.commoditySet.iterator();
        for (AbstractCommodity s : this.commoditySet) {
            s.prepare();
        }
        Date date1 = new SimpleDateFormat("yyyy/mm/dd").parse(date);
        this.maintenanceDates.add(date1);
    }

    //Prepares commodities in a room & adds a maintenance record with current date
    void prepareCommoditiesWithCurrentTime(){
        for (AbstractCommodity s : this.commoditySet) {
            s.prepare();
        }
        this.maintenanceDates.add(Calendar.getInstance().getTime());
    }

    void createBooking(String guestName, int guestId, Date from, Date to){
        Booking booking = new Booking();
        booking.Booking(guestName, guestId, from, to);
        this.bookings.add(booking);
    }

    void removeBooking(String guestName, int guestId, Date from, Date to){
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

    boolean IsAPerfectMatchRoom(int numberOfCouples, int numberOfPeopleSleepingAlone){
        int numberOfCouplesCount = 0;
        int numberOfPeopleSleepingAloneCount = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if(s.getNumberOfPersonasPerBed()==2) {
                numberOfCouplesCount++;
            }
            if(s.getNumberOfPersonasPerBed()==2) {
                numberOfPeopleSleepingAloneCount++;
            }
        }
        if(numberOfCouplesCount==numberOfCouples && numberOfPeopleSleepingAloneCount==numberOfPeopleSleepingAlone){
            return true;
        }
        else return false;
    }

}
