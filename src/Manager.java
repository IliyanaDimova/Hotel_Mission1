import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Manager {

    private String name;
    private Hotel hotel;

    void Manager(String name, Hotel hotel)
    {
        this.name = name;
        this.hotel = hotel;
    }

    Manager(String name)
    {
        this.name = name;
    }

    void Manager(Hotel hotel)
    {
        this.hotel = hotel;
    }

    String getName()
    {
        return this.name;
    }

    String getHotel()
    {
        return this.hotel.getName();
    }

    ArrayList<Room> getHotelRooms()
    {
        return this.hotel.getRooms();
    }

    Date stringToDate(String stringDate)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        try {

            Date date = formatter.parse(stringDate);
            return date;

        } catch (ParseException e) {
            System.out.println("Parse throws exception");
            return null;
        }

    }

    Room findPerfectFitRoomOrReturnNull(String stringFrom, String stringTo, int personas)
    {
        Date from = stringToDate(stringFrom);
        Date to = stringToDate(stringTo);
        return this.hotel.findPerfectFitRoomOrReturnNull( from, to, personas);
    }

}
