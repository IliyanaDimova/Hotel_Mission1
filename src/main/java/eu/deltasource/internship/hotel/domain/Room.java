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
 * Capacity - the number of people that can sleep in the room
 */
public class Room {

    private int number;
    private Set<AbstractCommodity> commoditySet;
    private Set<LocalDate> maintenanceDates;
    private Set<Booking> bookings;
    private int capacity;

    /**
     * Empty Room constructor without number, not added to hotel yet
     */
    public Room() {
        number = 0;
        commoditySet = new HashSet<>();
        maintenanceDates = new HashSet<>();
        bookings = new HashSet<>();
        capacity = 0;
    }

    public int getCapacity(){
        return capacity;
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
        capacity = 0;
    }

    //needs the hotel to access the static commodity number count
    public void setCommodities(Set<AbstractCommodity> set, Hotel hotel) {
        for (AbstractCommodity commodity : commoditySet) {
            addCommodity(commodity, hotel);
            if(commodity instanceof Bed){
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

    public Set getBookings() {
        return bookings;
    }

    /**
     * Adds a new commodity to the room, creating unique number for it
     * then increases the static commodityNumCount with 1 for the unique number of the next commodity to be added to the room
     * It checks is the commodity already belongs to another room - if it does => throws exception
     *
     * @param commodity the commodity to be added
     */
    public void addCommodity(AbstractCommodity commodity, Hotel hotel) throws CommodityAlreadyBelongsToRoomException {
        if (commodity.getInventoryNumber() == 0) {
            commodity.setInventoryNumber(hotel.getCommodityNumCountAndIncrementIt());
            commoditySet.add(commodity);
            if(commodity instanceof Bed){
                Bed bed = (Bed) commodity;
                capacity += bed.getNumberOfPersona();
            }
        } else {
            throw new CommodityAlreadyBelongsToRoomException("This commodity already belongs to a room");
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
     */
    public void createBooking(String guestId, LocalDate from, LocalDate to) throws TimeTravelException {
        LocalDate today = LocalDate.now();
        if (from.isBefore(today)) {
            throw new TimeTravelException("Humans can't time travel for now");
        }
        Booking booking = new Booking(guestId, from, to);
        bookings.add(booking);
        prepareCommodities(from);
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
        System.out.println("doDateOverlap =  " + !doDateOverlap(from, to));
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
