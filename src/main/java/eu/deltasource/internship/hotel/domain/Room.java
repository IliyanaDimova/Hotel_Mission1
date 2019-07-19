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

    /**
     * Room constructor
     *
     * @param room another room from which new room's fields are initialized
     */
    public Room(Room room) {
        number = room.number;
        commoditySet = room.getCommodities();
        bookings = room.getBookings();
        maintenanceDates = room.getMaintenanceDates();
    }

    /**
     * Room constructor. Initializes all fields
     *
     * @param roomNumber the unique number of the room
     */
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

    /**
     * Adds a meintanance date
     *
     * @param maintenanceDate the date to be added
     */
    public void addMaintenanceDate(LocalDate maintenanceDate) {
        maintenanceDates.add(maintenanceDate);
    }

    public Set getMaintenanceDates() {
        return maintenanceDates;
    }

    /**
     * Adds a booking to bookings of the room
     *
     * @param booking the booking to be added
     */
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public Set getBookings() {
        return bookings;
    }

    /**
     * Adds a new commodity to the room
     *
     * @param commodity the commodity to be added
     */
    public void addCommodity(AbstractCommodity commodity) {
        commoditySet.add(commodity);
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
        System.out.println("-->Started findIfAvailable for room# " + getNumber());
        int capacity = countSleepingPlaces();
        System.out.println("###Capacity: " + capacity);
        //if there are no bookings for the room OR from-to doesn't overlap with any booking intervals =>
        //return true if (the capacity of the room is == guests wanting to stay)
        if (bookings.isEmpty() || (!doDateOverlap(from, to))) {
            if (capacity == guests) {
                System.out.println("!!!!!return true");
                return true;
            }
            else {
                System.out.println("!!!!!return false ");
                return false;
            }
        } else {
            //return false if dates overlap
            System.out.println("!!!!!returns: false");
            return false;
        }
        //todo if the capacity is bigger, can't guests stay?
    }

    /**
     * @return number of sleeping places in a room
     */
    public int countSleepingPlaces() {
        int sleepingPlaces = 0;
        for (AbstractCommodity commodity : commoditySet) {
            if (commodity instanceof Bed) {
                Bed bed = (Bed) commodity;
                System.out.println("bed.getNumberOfPersona() = " + bed.getNumberOfPersona());
                sleepingPlaces += bed.getNumberOfPersona();
            }
        }
        return sleepingPlaces;
    }

    /**
     * Goes through all bookings and checks if any of them overlaps with the time interval
     *
     * @param from LocalDate from which the room will be occupied by the quests
     * @param to   LocalDate to which the room will be occupied by the quests
     * @return false if there are no overlaps, true if there are
     */
    public boolean doDateOverlap(LocalDate from, LocalDate to) {
        int ovelapCount = 0;
        for (Booking booking : bookings) {
            if (booking.checkIfDatesOverlap(from, to)) {
                ovelapCount++;
            }
        }
        if (ovelapCount == 0) {
            return false;
        } else {
            return true;
        }
    }

}
