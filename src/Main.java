import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Manager manager = new Manager("Pesho Peshov");

        Room room1 = new Room(1);
        Room room2 = new Room(2);

        ArrayList<Room> hotelRooms = new ArrayList<>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        Hotel hotel = new Hotel("Trivago", hotelRooms);

        if(manager.checkForFreeRooms())
        {
            manager.bookTheFirstAvailableRoom();
        }
        manager.clearAllBookings(hotel);
    }
}
