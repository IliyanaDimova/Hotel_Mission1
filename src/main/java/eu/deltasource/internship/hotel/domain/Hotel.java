package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Class main.java.eu.deltasource.internship.hotel.domain.Hotel is assigned to a manager. It's fields are:
 * main.java.eu.deltasource.internship.hotel.domain.Hotel's name
 * List of rooms of Class main.java.eu.deltasource.internship.hotel.domain.Room
 * roomNumCount is a static variable that saves the last assigned commodity number (in order to create unique room numbers)
 */
public class Hotel {
    private String name;
    private Set<Room> rooms;
    private static int commodityNumCount;

    /**
     * Empty Hotel constructor (initializes all fields)
     */
    public Hotel() {
        name = new String();
        rooms = new HashSet();
        commodityNumCount = 1;
    }

    /**
     * Hotel constructor
     * commodityNumCount starts from 1 cuz you can't have 0 for inventory number
     *
     * @param name the name that will be assigned to the hotel
     */
    public Hotel(String name) {
        this.name = name;
        rooms = new HashSet();
        commodityNumCount = 1;
    }

    public void addRooms(int numOfRooms) {
        for (int i = 0; i < numOfRooms; i++) {
            Room room = new Room(rooms.size() + 1);
            rooms.add(room);
        }
    }

    public void addSameCommodityToEveryRoom(AbstractCommodity commodity) {
        for (Room room : rooms) {
            room.addCommodity(commodity, this);
        }
    }

    /**
     * returns commodityNumCount and increments it
     *
     * @return the last set inventory number of a commodity in the hotel
     */
    public int getCommodityNumCountAndIncrementIt() {
        commodityNumCount++;
        return (commodityNumCount - 1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a new room to the hotel and increments the roomNumCount with 1
     *
     * @param room the room to be added
     */
    public void addRoom(Room room) {
        room.setNumber(rooms.size() + 1);
        rooms.add(room);
    }

    public void setRooms(Set<Room> givenRooms) {
        rooms = givenRooms;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public int getRoomNumCount() {
        return (rooms.size() + 1);
    }

    public int getRoomCount() {
        return rooms.size();
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
        System.out.println("\n--> findAvailableRooms started");
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : this.getRooms()) {
            System.out.println("\n~~~looping room# " + room.getNumber());
            if (room.findIfAvailable(from, to, capacity)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

}
