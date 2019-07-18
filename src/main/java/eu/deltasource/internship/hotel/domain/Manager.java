package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * main.java.eu.deltasource.internship.hotel.domain.Manager Class with fields:
 * name of the manager
 * hotel of class main.java.eu.deltasource.internship.hotel.domain.Hotel assigned to the manager
 */
public class Manager {

    private String name;
    private Hotel hotel;

    /**
     * Manager constructor
     *
     * @param name the name of the manager (String)
     */
    public Manager(String name) {
        this.name = name;
        hotel = new Hotel();
    }

    /**
     * Assigns hotel to the manager
     *
     * @param hotel the hotel to be assigned
     */
    public void assignHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Manager))
            return false;
        Manager manager = (Manager) obj;
        return (manager.name == this.name);
    }

    @Override
    public int hashCode() {
        return name.length() * 12;
    }

    public String getName() {
        return name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelName() {
        return hotel.getName();
    }

    public Set<Room> getHotelRooms() {
        return hotel.getRooms();
    }

    /**
     * Takes a String and turns it into LocalDate
     *
     * @param stringDate string to turn into LocalDate
     * @return the converted from String LocalDate
     */
    public LocalDate stringToLocalDate(String stringDate) {
        LocalDate date = LocalDate.parse(stringDate);
        if (date == null) {
            System.out.println("Date failed to parse!");
            return null;
        }
        return date;
    }

    /**
     * Through this method the manager can book a room for the time interval and size
     *
     * @param guestId  The EGN of one of the guests that want to book the same room
     * @param from     date from which the guests want to book the room
     * @param to       date to which the guests want to book the room
     * @param capacity how many guests want to book the room
     * @return the number of the booked room
     * @throws Exception if no room was booked
     */
    public int createBooking(String guestId, LocalDate from, LocalDate to, int capacity) throws MyException {
        Set<Room> availableRooms = new HashSet<>();
        availableRooms = hotel.findAvailableRooms(from, to, capacity);
        int bookedRoomNum = 0;
        if (!availableRooms.isEmpty()) {
            for (Room room : availableRooms) {
                bookedRoomNum = room.getNumber();
                room.createBooking(guestId, from, to);
                break;
            }
        } else {
            throw new MyException("There are no available rooms for " + capacity + " people from: " + from.toString() + " to: " + to.toString());
        }
        return bookedRoomNum;
    }

}
