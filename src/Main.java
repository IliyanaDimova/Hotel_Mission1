import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) {
        Manager manager = new Manager("Pesho Peshov");

        Room room1 = new Room(1);
        Room room2 = new Room(2);

        ArrayList<Room> hotelRooms = new ArrayList<Room>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.Manager(hotel);

        if(manager.checkForFreeRooms()) {
            manager.bookTheFirstAvailableRoom();
        }
        manager.clearAllBookings(hotel);
    }
}

//tested if prepare() works;
        /*
        Room room =new Room(103);
        HashSet<AbstractCommodity> givenCommoditySet = new HashSet<>();
        Toilet r=new Toilet();
        givenCommoditySet.add(r);
        room.setCommoditySet(givenCommoditySet);
        room.prepareCommodities();
        */