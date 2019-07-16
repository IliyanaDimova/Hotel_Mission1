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

    public Hotel() {
        this.name = "Default name";
        this.rooms = null;
    }

    public Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getRoomCount() {
        return rooms.size();
    }

    /**
     * Loops through all rooms in the hotel and adds the ones meeting the criteria to a List
     *
     * @param from   LocalDate from which the guests want to book a room in the hotel
     * @param to     LocalDate to which the guests want to book a room in the hotel
     * @param guests number of people that want to book a room together
     * @return List of all rooms that have the exact capacity to hold the numberOfPeople
     */
    public ArrayList<Room> findAllAvailableRoomsForIntervalAndSize(LocalDate from, LocalDate to, int guests) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).availableForIntervalAndSize(from, to, guests)) {
                availableRooms.add(rooms.get(i));
            }
        }
        return availableRooms;
    }

    /**
     * availableRooms is a List of rooms matching the criteria (people = sleeping places)
     *
     * @param from   LocalDate from which the guests want to book a room in the hotel
     * @param to     LocalDate to which the guests want to book a room in the hotel
     * @param guests guests wanting to book a room together
     * @return the first room meeting the criteria
     */
    public Room findPerfectFitRoom(LocalDate from, LocalDate to, int guests) {
        ArrayList<Room> availableRooms = findAllAvailableRoomsForIntervalAndSize(from, to, guests);

        if (availableRooms.size() == 0) {
            System.out.println("There are no rooms matching the criteria!");
            return null;
        } else {
            System.out.println("Perfect room is room# " + availableRooms.get(0).getNumber());
            return availableRooms.get(0);
        }
    }

}
