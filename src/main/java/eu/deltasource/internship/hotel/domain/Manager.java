package eu.deltasource.internship.hotel.domain;

import java.util.ArrayList;
import java.time.LocalDate;

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

    public String getHotelName() {
        return hotel.getName();
    }

    public ArrayList<Room> getHotelRooms() {
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
     * Finds a room that can hold exact number of people
     *
     * @param stringFrom converts to LocalDate
     * @param stringTo   converts to LocalDate
     * @param guests     number of people wanting to book a room together
     * @return the perfect fit room (if there isn't such room return null)
     */
    /*public Room findPerfectFitRoom(String stringFrom, String stringTo, int guests) {
        LocalDate from = stringToLocalDate(stringFrom);
        LocalDate to = stringToLocalDate(stringTo);
        if (from == null || to == null) {
            System.out.println("String didn't convert to Date");
            return null;
        }
        return hotel.findPerfectFitRoom(from, to, guests);
    }*/

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
    public int createBooking(String guestId, LocalDate from, LocalDate to, int capacity) throws Exception {
        ArrayList<Room> availableRooms = new ArrayList<>();
        availableRooms = hotel.findAvailableRooms(from, to, capacity);
        if (availableRooms.size() > 0) {
            availableRooms.get(0).createBooking(guestId, from, to);
        } else {
            throw new Exception("There are no available rooms for " + capacity + " people from: " + from.toString() + " to: " + to.toString());
        }
        return availableRooms.get(0).getNumber();
    }

}
