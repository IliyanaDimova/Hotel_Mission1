import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Manager {

    private String name;
    private Hotel hotel;

    void Manager(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    Manager(String name) {
        this.name = name;
    }

    void Manager(Hotel hotel) {
        this.hotel = hotel;
    }

    String getName(){
        return this.name;
    }

    String getHotel(){
        return this.hotel.getName();
    }

    ArrayList<Room> getHotelRooms(){
        return this.hotel.getRooms();
    }

    Room findPerfectFitRoomOrReturnNull(String from, String to, int numberOfCouples, int numberOfPeopleSleepingAlone) throws ParseException {
        Date dateFrom = new SimpleDateFormat("yyyy/mm/dd").parse(from);
        Date dateTo = new SimpleDateFormat("yyyy/mm/dd").parse(to);
        return this.hotel.findPerfectFitRoomOrReturnNull( dateFrom, dateTo, numberOfCouples, numberOfPeopleSleepingAlone);
    }

}
