package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.Set;

/**
 * Manager with fields:
 * name of the manager
 * Hotel assigned to the manager
 */
public class Manager {

    private String name;
    private Hotel hotel;

    /**
     * Manager constructor
     *
     * @param name the name of the manager
     */
    public Manager(String name) {
        this.name = name;
    }

    public void assignHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @return the assigned hotel's name
     */
    public String getHotelName() {
        return hotel.getName();
    }

    /**
     * @return the rooms that belong to manager's hotel
     */
    public Set<Room> getHotelRooms() {
        return hotel.getRooms();
    }

    /**
     * Through this method the manager can book a room for the time interval and size
     *
     * @param guestId  The EGN of one of the guests that want to book the same room
     * @param from     date from which the guests want to book the room
     * @param to       date to which the guests want to book the room
     * @param capacity how many guests want to book the room
     * @return the number of the booked room
     * @throws Exception if room wasn't booked
     */
    public int createBooking(String guestId, LocalDate from, LocalDate to, int capacity) throws NoRoomsAvailableException {
        System.out.println("\n\n\ncreateBooking started for " + from + " - " + to + " -->");
        Set<Room> availableRooms;
        availableRooms = hotel.findAvailableRooms(from, to, capacity);

        if (!(availableRooms.isEmpty())) {
            availableRooms.iterator().next().createBooking(guestId, from, to);
        } else {
            throw new NoRoomsAvailableException("There are no available rooms for " + capacity + " people from: " + from.toString() + " to: " + to.toString());
        }
        return availableRooms.iterator().next().getNumber();
    }

}
