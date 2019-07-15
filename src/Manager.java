import java.util.ArrayList;
import java.time.LocalDate;

public class Manager {

    private String name;
    private Hotel hotel;

    Manager(String name)
    {
        this.name = name;
        hotel = null;
    }

    public void managerAssignHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }

    public String getName()
    {
        return this.name;
    }

    public String getHotel()
    {
        return this.hotel.getName();
    }

    public ArrayList<Room> getHotelRooms()
    {
        return this.hotel.getRooms();
    }

    public LocalDate stringToLocalDate(String stringDate)
    {
        LocalDate date = LocalDate.parse(stringDate);
        System.out.println("Successfully turned String to LocalDate " + date);
        return date;
    }

    public Room findPerfectFitRoomOrReturnNull(String stringFrom, String stringTo, int personas)
    {
        LocalDate from = stringToLocalDate(stringFrom);
        LocalDate to = stringToLocalDate(stringTo);
        System.out.println("Room's number is " );
        return this.hotel.findPerfectFitRoomOrReturnNull( from, to, personas);
    }

}
