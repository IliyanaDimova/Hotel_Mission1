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

    public Manager(String name) {
        this.name = name;
        hotel = null;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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
        if(date==null){
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
    public Room findPerfectFitRoom(String stringFrom, String stringTo, int guests) {
        LocalDate from = stringToLocalDate(stringFrom);
        LocalDate to = stringToLocalDate(stringTo);
        if (from == null || to == null) {
            System.out.println("String didn't convert to Date");
            return null;
        }
        return hotel.findPerfectFitRoom(from, to, guests);
    }

}
