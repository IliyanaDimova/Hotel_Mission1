package eu.deltasource.internship.hotel.domain;

import java.time.LocalDate;
import java.util.*;

/**
 * Hotel is assigned to a manager. It's fields are:
 * Hotel's name
 * Map of Room with key room's number
 */
public class Hotel {
    private String name;
    private Map<Integer, Room> rooms;

    /**
     * Hotel constructor
     *
     * @param name  the name that will be assigned to the hotel (You can't create a hotel without a name)
     * @param rooms the Map of rooms to be added to the hotel
     */
    public Hotel(String name, Map rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    /**
     * Hotel constructor. Calls the other Hotel constructor, initializing empty rooms
     *
     * @param name the name of the Hotel
     */
    public Hotel(String name) {
        this(name, new HashMap<Integer, Room>());
    }

    /**
     * Add numOfRooms rooms to a hotel. It gives the rooms their unique number using the size of room's Set + 1 (because you can't have 0 for a room number)
     *
     * @param numOfRooms          the number of the rooms you want to add
     * @param rememberLastRoomNum generates unique room numbers (remembers the last given room number)
     */
    public void addRooms(int numOfRooms, UniqueRoomNumber rememberLastRoomNum) {
        for (int i = 0; i < numOfRooms; i++) {
            Room room = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
            rooms.put(room.getNumber(), room);
        }
    }

    /**
     * Adds one commodity in every room in the hotel assigning unique inventory number to every single one
     * It will be handy to add a shower to every room in one move instead of adding the same shower to every single room
     *
     * @param commodity the commodity to be added to every room
     */
    public void addSameCommodityToEveryRoom(AbstractCommodity commodity) {
        UniqueCommodityNumber comNum = new UniqueCommodityNumber();
        Iterator entries = rooms.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Room value = (Room) entry.getValue();
            commodity.setInventoryNumber(comNum.getCommodityNumAndIncrement());
            value.addCommodity(commodity);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a new room to the hotel, giving it it's unique number using the size of the Set of rooms in the hotel + 1
     *
     * @param room the room to be added
     */
    public void addRoom(Room room) {
        room.setNumber(rooms.size() + 1);
        rooms.put(room.getNumber(), room);
    }

    public void setRooms(Map<Integer, Room> givenRooms) {
        rooms = givenRooms;
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public int getRoomNumCount() {
        return (rooms.size() + 1);
    }

    public int getRoomsSize() {
        return rooms.size();
    }

    /**
     * Loops through all rooms in the hotel and adds the ones meeting the criteria to a List
     *
     * @param from     The date from which the guests want to book a room in the hotel
     * @param to       The date to which the guests want to book a room in the hotel
     * @param capacity number of people that want to book a room together
     * @return List of all rooms that have the exact capacity to hold the numberOfPeople
     */
    public Set<Room> findAvailableRooms(LocalDate from, LocalDate to, int capacity) {
        System.out.println("\n--> findAvailableRooms started");
        Set<Room> availableRooms = new HashSet<>();
        Iterator entries = rooms.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Room value = (Room) entry.getValue();
            if (value.findIfAvailable(from, to, capacity)) {
                availableRooms.add(value);
            }
        }
        return availableRooms;
    }

}
