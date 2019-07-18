package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Room (Every Hotel has a set of rooms) with fields:
 * room number
 * Set of Commodities - toilets, showers, beds
 * Set of dates that the room had been prepared
 * Set of bookings (booked from guests for time intervals)
 * A static variable - roomNumCount that remembers the last initialized room's number in order to create unique number for all rooms
 */
public class Room {

    private int number;
    private Set<AbstractCommodity> commoditySet;
    private Set<LocalDate> maintenanceDates;
    private Set<Booking> bookings;

    public Room(Room room) {
        number = room.number;
        commoditySet = room.getCommodities();
        bookings = room.getBookings();
        maintenanceDates = room.getMaintenanceDates();
    }

    public Room(int roomNumber) {
        number = roomNumber;
        commoditySet = new HashSet<>();
        maintenanceDates = new HashSet<>();
        bookings = new HashSet<>();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addMaintenanceDate(LocalDate maintenanceDate) {
        maintenanceDates.add(maintenanceDate);
    }

    public Set getMaintenanceDates(){
        return maintenanceDates;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public Set getBookings(){
        return bookings;
    }

    public void addCommodity(AbstractCommodity commodity) {
        commoditySet.add(commodity);
    }

    public Set getCommodities(){
        return commoditySet;
    }

    /**
     * Prepares all the commodities in the room by accessing the commodities through AbstractCommodities prepare()
     *
     * @param date to be added to room's maintenanceDates Set
     */
    public void prepareCommodities(LocalDate date) {
        for (AbstractCommodity commodity : commoditySet) {
            if (number == commodity.hashCode()) {
                commodity.prepare();
            }
        }
        maintenanceDates.add(date);
    }

    /**
     * Adds a booking to room's bookings Set
     *
     * @param guestId the EGN of the same person
     * @param from    LocalDate from which the room will be occupied by the quests
     * @param to      LocalDate from which the room will be occupied by the quests
     */
    public void createBooking(String guestId, LocalDate from, LocalDate to) {
        Booking booking = new Booking(guestId, from, to);
        bookings.add(booking);
        prepareCommodities(from);
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
        Booking booking = new Booking(guestId, from, to);
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
    public boolean findIfAvailable(LocalDate from, LocalDate to, int guests) {
        int ovelapCount = 0;
        int capacity;

        if (!bookings.isEmpty()) {
            ovelapCount = countDateOverlap(from, to);
        }
        //todo too many empty spaces
        capacity = countSleepingPlaces();
        //todo if the capacity is bigger, can't guests stay?
        if ((capacity == guests) && (ovelapCount == 0)) {
            return true;
        } else {
            return false;
        }

        //todo return ((capacity == guests) && (overlapCount==0)) ? true:false;
    }

    /**
     * @return number of sleeping places in a room
     */
    public int countSleepingPlaces() {
        int sleepingPlaces = 0;
        for (AbstractCommodity commodity : this.commoditySet) {
            if (commodity instanceof Bed /* && commodity.hashCode() == this.getNumber()*/) {
                Bed bed = (Bed) commodity;
                sleepingPlaces += bed.getNumberOfPersona();
                System.out.println("sleepingPlaces = " + sleepingPlaces);
            }
        }
        return sleepingPlaces;
    }

    /** //todo explanation, not only params
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
        return ovelapCount; //todo shouldn't this return a boolean?
    }

}
