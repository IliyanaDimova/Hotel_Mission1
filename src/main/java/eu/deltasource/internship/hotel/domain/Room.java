package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Room (Every Hotel has a set of rooms) with fields:
 * room number
 * Set of Commodities - toilets, showers, beds
 * Set of dates that the room had been prepared
 * Set of bookings (booked from guests for time intervals)
 * Capacity - the number of people that can sleep in the room
 */
public class Room {

    private int number;
    private Set<AbstractCommodity> commoditySet;
    private Set<LocalDate> maintenanceDates;
    private Set<Booking> bookings;
    private int capacity;

    /**
     * Room constructor
     *
     * @param number           the room's unique number
     * @param commodities      the set of commodities in the room
     * @param maintenanceDates the set of dates the room has been prepared
     * @param bookings         the set of Bookings for the room
     * @param capacity         the capacity of the room
     */
    public Room(int number, Set<AbstractCommodity> commodities, Set<LocalDate> maintenanceDates, Set<Booking> bookings, int capacity) {
        this.number = number;
        this.commoditySet = commodities;
        this.maintenanceDates = maintenanceDates;
        this.bookings = bookings;
        this.capacity = capacity;
    }

    /**
     * Room constructor. Initializes all fields to null/0, but gives unique number to the room
     *
     * @param number the unique number of the room
     */
    public Room(int number) {
        this(number, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCommodities(Set<AbstractCommodity> set) {
        for (AbstractCommodity commodity : set) {
            addCommodity(commodity);
            if (commodity instanceof Bed) {
                Bed bed = (Bed) commodity;
                capacity += bed.getNumberOfPersona();
            }
        }
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

    public Set getMaintenanceDates() {
        return maintenanceDates;
    }

    public Set getBookings() {
        return bookings;
    }

    /**
     * Adds a new commodity to the room, creating unique number for it
     *
     * @param commodity the commodity to be added
     */
    public void addCommodity(AbstractCommodity commodity) {
        commoditySet.add(commodity);
        if (commodity instanceof Bed) {
            Bed bed = (Bed) commodity;
            capacity += bed.getNumberOfPersona();
        }
    }

    public Set getCommodities() {
        return commoditySet;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Room))
            return false;
        Room room = (Room) obj;
        return (room.number == this.number);
    }

    @Override
    public int hashCode() {
        return number;
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
     * @param guestId the EGN of the same person
     * @param from    LocalDate from which the room will be occupied by the quests
     * @param to      LocalDate from which the room will be occupied by the quests
     * @throws TimeTravelException (RuntimeException Extender) if from starts before today's date
     */
    public void createBooking(String guestId, LocalDate from, LocalDate to) throws TimeTravelException {
        checkGuestId(guestId);
        LocalDate today = LocalDate.now();
        if (from.isBefore(today)) {
            throw new TimeTravelException("Humans can't time travel for now");
        }
        Booking booking = new Booking(guestId, from, to);
        bookings.add(booking);
        prepareCommodities(from);
    }

    /**
     * Checks if guests ID is correct (10 numeric characters)
     *
     * @param guestId the String to be checked
     * @throws IncorrectGuestIdException if the ID is incorrect
     */
    public void checkGuestId(String guestId) throws IncorrectGuestIdException {
        if ((guestId.length() != 10) || !(stringIsNumeric(guestId))) {
            throw new IncorrectGuestIdException("Guest ID is incorrectly entered!");
        }
    }

    /**
     * Checks is a string is numeric
     *
     * @param string the String to be checked
     * @return true if it's numeric, else if it contains other characters
     */
    private boolean stringIsNumeric(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * Removes a booking from room's bookings Set
     *
     * @param guestId the EGN of the same person
     * @param from    LocalDate from which the room will be occupied by the quests
     * @param to      LocalDate from which the room will be occupied by the quests
     */
    public void removeBooking(String guestId, LocalDate from, LocalDate to) {
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
        System.out.println("-->Started findIfAvailable for room# " + getNumber());
        System.out.println("Capacity =  " + capacity);
        if (!doDateOverlap(from, to)) {
            if (capacity == guests) {
                System.out.println("!!!!!return true");
                return true;
            } else {
                System.out.println("!!!!!return false ");
                return false;
            }
        } else {
            //return false if dates overlap
            System.out.println("!!!!!returns: false");
            return false;
        }
    }

    /**
     * Goes through all bookings and checks if any of them overlaps with the time interval
     *
     * @param from LocalDate from which the room will be occupied by the quests
     * @param to   LocalDate to which the room will be occupied by the quests
     * @return false if there are no overlaps, true if there are
     */
    public boolean doDateOverlap(LocalDate from, LocalDate to) {
        int overlapCount = 0;
        for (Booking booking : bookings) {
            if (booking.checkIfDatesOverlap(from, to)) {
                overlapCount++;
            }
        }
        if (overlapCount == 0) {
            return false;
        } else {
            return true;
        }
    }
}
