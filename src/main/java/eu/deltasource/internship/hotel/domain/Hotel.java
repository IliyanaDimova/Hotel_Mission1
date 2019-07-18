package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class main.java.eu.deltasource.internship.hotel.domain.Hotel is assigned to a manager. It's fields are:
 * main.java.eu.deltasource.internship.hotel.domain.Hotel's name
 * List of rooms of Class main.java.eu.deltasource.internship.hotel.domain.Room
 */
public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel()

    /**
     * Hotel constructor
     *
     * @param name the name that will be assigned to the hotel
     */
    public Hotel(String name) {
        this.name = name;
    }

    /**
     * Hotel constructor
     *
     * @param name  the name that will be assigned to the hotel
     * @param rooms set of rooms for the hotel
     */
    public Hotel(String name, ArrayList<Room> rooms) {
        this(name);
        this.rooms = rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRooms(ArrayList<Room> givenRooms) {
        for (int i=0; i<givenRooms.size(); i++){
            rooms.add(givenRooms.get(i));
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getRoomCount() {
        return rooms.size();
    }

    /**
     * Adds a new room to the hotel
     * @param room the room to be added
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Loops through all rooms in the hotel and adds the ones meeting the criteria to a List
     *
     * @param from     LocalDate from which the guests want to book a room in the hotel
     * @param to       LocalDate to which the guests want to book a room in the hotel
     * @param capacity number of people that want to book a room together
     * @return List of all rooms that have the exact capacity to hold the numberOfPeople
     */
    public ArrayList<Room> findAvailableRooms(LocalDate from, LocalDate to, int capacity) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).findIfAvailable(from, to, capacity)) {
                availableRooms.add(rooms.get(i));
            }
        }
        return availableRooms;
    }

}
