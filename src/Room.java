import java.util.HashSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class Room {

    private int number;
    private HashSet<AbstractCommodity> commoditySet;
    private HashSet<LocalDate> maintenanceDates;
    private HashSet<Booking> bookings;

    Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setCommoditySet(HashSet<AbstractCommodity> givenCommoditySet) {
        this.commoditySet = givenCommoditySet;
    }

    public LocalDate stringToLocalDate(String stringDate) {
        LocalDate date = LocalDate.parse(stringDate);
        return date;
    }

    //Prepares commodities in a room & adds a maintenance record through string
    public void prepareCommodities(LocalDate date) {
        for (AbstractCommodity s : this.commoditySet) {
            s.prepare();
        }
        this.maintenanceDates.add(date);
    }

    public void createBooking(String guestName, String guestId, LocalDate from, LocalDate to) {
        Booking booking = new Booking();
        booking.Booking(guestName, guestId, from, to);
        this.bookings.add(booking);
    }

    public void removeBooking(String guestName, String guestId, LocalDate from, LocalDate to) {
        Booking booking = new Booking();
        booking.Booking(guestName, guestId, from, to);
        this.bookings.remove(booking);
    }

    //Returns room that are unbooked for the time period & have at least the min number of beds
    //this returned rooms will be added to arraylist and checked for the best match of beds
    public boolean findIfAvailableForIntervalAndSize(LocalDate from, LocalDate to, int numberOfPeople) {
        int ovelapCount = 0;
        int sleepingPlaces = 0;
        this.bookings = new HashSet();
        if (!this.bookings.isEmpty()) {
            for (Booking s : this.bookings) {
                if (s.checkIfDatesOverlap(from, to)) {
                    ovelapCount++;
                }
            }
        }

        //looping through all beds and adding number of persona to sleepingPlaces
        for (AbstractCommodity commodity : commoditySet) {
            if (commodity instanceof Bed) {
                Bed bed = (Bed) commodity;
                sleepingPlaces += bed.getNumberOfPersonaPerBed();
            }
        }


        if ((sleepingPlaces >= numberOfPeople) && (ovelapCount == 0)) {
            return true;
        } else return false;
    }

    /*public int getNumberOfTwoPersonaBeds() {
        int number = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if (s.getNumberOfPersonaPerBed() == 2) {
                number++;
            }
        }
        return number;
    }

    public int getNumberOfOnePersonaBeds() {
        int number = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if (s.getNumberOfPersonaPerBed() == 1) {
                number++;
            }
        }
        return number;
    }*/

    public boolean IsAPerfectMatchRoom(int personas) {
        int numberOfPersonasCount = 0;
        for (AbstractCommodity s : this.commoditySet) {
            if (s.getNumberOfPersonasPerBed() > 0) {
                numberOfPersonasCount++;
            }
        }
        if (numberOfPersonasCount == personas) {
            return true;
        } else return false;
    }

    public boolean bookRoomForInterval(String stringFrom, String stringTo, String guestName, String guestId) {
        LocalDate from = stringToLocalDate(stringFrom);
        LocalDate to = stringToLocalDate(stringTo);
        if (from == null || to == null) {
            System.out.println("String didn't convert to Date");
            return false;
        }
        this.createBooking(guestName, guestId, from, to);
        this.prepareCommodities(from);
        return true;
    }

}
