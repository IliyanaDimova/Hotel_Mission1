import java.util.HashSet;
import java.time.LocalDate;

/**
 * Class Room with fields:
 * room number
 * Set of Commodities - toilets, showers, beds
 * Set of dates that the room had been prepared
 * Set of bookings (booked from guests for time intervals)
 */
public class Room {

    private int number;
    private HashSet<AbstractCommodity> commoditySet;
    private HashSet<LocalDate> maintenanceDates;
    private HashSet<Booking> bookings;

    Room(int number, HashSet<AbstractCommodity> commoditySet) {
        this.number = number;
        this.commoditySet = commoditySet;
        maintenanceDates = new HashSet<>();
        bookings = new HashSet<>();
    }

    public int getNumber() {
        return number;
    }

    public void setCommoditySet(HashSet<AbstractCommodity> givenCommoditySet) {
        commoditySet = givenCommoditySet;
    }

    /**
     * converts String to LocalDate
     *
     * @param stringDate String to be converted
     * @return the converted LocalDate
     */
    public LocalDate stringToLocalDate(String stringDate) {
        LocalDate date = LocalDate.parse(stringDate);
        return date;
    }

    /**
     * Prepares all the commodities in the room by accessing the commodities through AbstractCommodities prepare()
     *
     * @param date to be added to room's maintenanceDates Set
     */
    public void prepareCommodities(LocalDate date) {
        for (AbstractCommodity commodity : commoditySet) {
            commodity.prepare();
        }
        maintenanceDates.add(date);
    }

    /**
     * Adds a booking to room's bookings Set
     *
     * @param guestName one of the guests that are booking the room's name
     * @param guestId   the EGN of the same person
     * @param from      LocalDate from which the room will be occupied by the quests
     * @param to        LocalDate from which the room will be occupied by the quests
     */
    public void createBooking(String guestName, String guestId, LocalDate from, LocalDate to) {
        Booking booking = new Booking(guestName, guestId, from, to);
        bookings.add(booking);
    }

    /**
     * Removes a booking from room's bookings Set
     *
     * @param guestName one of the guests that are booking the room's name
     * @param guestId   the EGN of the same person
     * @param from      LocalDate from which the room will be occupied by the quests
     * @param to        LocalDate from which the room will be occupied by the quests
     */
    public void removeBooking(String guestName, String guestId, LocalDate from, LocalDate to) {
        Booking booking = new Booking(guestName, guestId, from, to);
        bookings.remove(booking);
    }

    /**
     * Finds if there are rooms matching the criteria
     *
     * @param from   LocalDate from which the room will be occupied by the quests
     * @param to     LocalDate from which the room will be occupied by the quests
     * @param guests People that wan to book the room together
     * @return true if there are rooms matching the criteria, false if not
     */
    public boolean availableForIntervalAndSize(LocalDate from, LocalDate to, int guests) {
        int ovelapCount = 0;
        int sleepingPlaces;

        if (!bookings.isEmpty()) {
            ovelapCount = countDateOverlap(from, to);
        }

        sleepingPlaces = countSleepingPlaces();

        if ((sleepingPlaces == guests) && (ovelapCount == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return number of sleeping places in a room
     */
    public int countSleepingPlaces() {
        int sleepingPlaces = 0;
        for (AbstractCommodity commodity : commoditySet) {
            if (commodity instanceof Bed) {
                Bed bed = (Bed) commodity;
                sleepingPlaces += bed.getNumberOfPersona();
            }
        }
        return sleepingPlaces;
    }

    /**
     * @param from LocalDate from which the room will be occupied by the quests
     * @param to   LocalDate to which the room will be occupied by the quests
     * @return number of times the interval from-to overlaps already booked intervals
     */
    public int countDateOverlap(LocalDate from, LocalDate to) {
        int ovelapCount = 0;
        for (Booking booking : bookings) {
            if (booking.checkIfDatesOverlap(from, to)) {
                ovelapCount++;
            }
        }
        return ovelapCount;
    }

    /**
     * Checks if guests == number of sleeping places
     * loops through all beds in the room to get all the sleeping places
     *
     * @param guests number of people wanting to book the room together
     * @return true if equal, false if not
     */
    public boolean IsAPerfectMatchRoom(int guests) {
        int numberOfSleepingPlaces = 0;
        for (AbstractCommodity commodity : commoditySet) {
            if (commodity instanceof Bed) {
                Bed bed = (Bed) commodity;
                numberOfSleepingPlaces += bed.getNumberOfPersona();
            }
        }
        if (numberOfSleepingPlaces == guests) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Converts Strings to LocalDates
     *
     * @param stringFrom String to be converted to LocalDate from which the quests want to book a room
     * @param stringTo   String to be converted to LocalDate to which the quests want to book a room
     * @param guestName  one of the guests that are booking the room's name
     * @param guestId    the EGN of the same person
     * @return false if Strings didn't convert to LocalDates properly, true if they did
     */
    public boolean bookRoomForInterval(String stringFrom, String stringTo, String guestName, String guestId) {
        LocalDate from = stringToLocalDate(stringFrom);
        LocalDate to = stringToLocalDate(stringTo);
        if (from == null || to == null) {
            System.out.println("String didn't convert to Date");
            return false;
        }
        createBooking(guestName, guestId, from, to);
        prepareCommodities(from);
        return true;
    }

}
