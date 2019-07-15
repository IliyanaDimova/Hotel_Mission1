import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Manager Class with fields:
 * name of the manager
 * hotel of class Hotel assigned to the manager
 */
public class Manager {

    private String name;
    private Hotel hotel;

    Manager(String name) {
        this.name = name;
        hotel = null;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public String getHotel() {
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
        return hotel.findPerfectFitRoom(from, to, guests);
    }

}
