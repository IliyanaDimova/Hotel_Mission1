package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class main.java.eu.deltasource.internship.hotel.domain.Hotel is assigned to a manager. It's fields are:
 * main.java.eu.deltasource.internship.hotel.domain.Hotel's name
 * List of rooms of Class main.java.eu.deltasource.internship.hotel.domain.Room
 * roomNumCount is a static variable that saves the last assigned room number (in order to create unique room numbers)
 */
public class Hotel {
    private String name;
    private Set<Room> rooms;
    private static int roomNumCount;

    /**
     * Empty Hotel constructor (initializes all fields)
     */
    public Hotel() {
        name = new String();
        rooms = new HashSet();
        roomNumCount = 0;
    }

    /**
     * Hotel constructor
     *
     * @param name the name that will be assigned to the hotel
     */
    public Hotel(String name) {
        this.name = name;
        rooms = new HashSet();
        roomNumCount = 0;
    }

    /**
     * Hotel constructor
     *
     * @param name  the name that will be assigned to the hotel
     * @param rooms set of rooms for the hotel
     */
    public Hotel(String name, Set<Room> rooms) {
        this(name);
        this.rooms = rooms;
        //todo roomcount = rooms.size()
    }

    public int getRoomNumCount(){
        return roomNumCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRooms(ArrayList<Room> givenRooms) {
        for (int i = 0; i < givenRooms.size(); i++) {
            rooms.add(givenRooms.get(i));
        }
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public int getRoomCount() {
        return rooms.size();
    }

    /**
     * Adds a new room to the hotel
     *
     * @param room the room to be added
     */
    public void addRoom(Room room) {
        rooms.add(room);
        //todo roomCount++;
    }

    /**
     * Loops through all rooms in the hotel and adds the ones meeting the criteria to a List
     *
     * @param from     LocalDate from which the guests want to book a room in the hotel
     * @param to       LocalDate to which the guests want to book a room in the hotel
     * @param capacity number of people that want to book a room together
     * @return List of all rooms that have the exact capacity to hold the numberOfPeople
     */
    public Set<Room> findAvailableRooms(LocalDate from, LocalDate to, int capacity) {
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : this.getRooms()) {
            if (room.findIfAvailable(from, to, capacity)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

}
