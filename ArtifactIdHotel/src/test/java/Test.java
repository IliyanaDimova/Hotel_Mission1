import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import java.util.ArrayList;

public class Test {
    Manager manager = new Manager("Pesho");
    Room room1 = new Room(1);
    Room room2 = new Room(2);
    ArrayList<Room> hotelRooms = new ArrayList<Room>(2);
    hotelRooms.add(room1);
    hotelRooms.add(room2);
    Hotel hotel = new Hotel("Trivago", hotelRooms);
    manager.Manager(hotel);

    manager.bookTheFirstAvailableRoom();
    manager.bookTheFirstAvailableRoom();

    *@org.junit.jupiter.api.Test
    public void prooveTereAreNoMoreFreeRooms() throws Exception{
        assertFalse(manager.checkForFreeRooms);
    }

    /*@org.junit.jupiter.api.Test
    public void managerName() throws Exception{
        assertEquals("Pesho", manager.name);
    }

    @org.junit.jupiter.api.Test
    public void managerHotel() throws Exception{
        assertEquals(hotel, manager.hotel);

    @org.junit.jupiter.api.Test
    public void hotelName() throws Exception{
        assertEquals("Trivago", hotel.name);
    }

    @org.junit.jupiter.api.Test
    public void hotelRoomsList() throws Exception{
        assertEquals(hotelRooms, hotel.rooms);
    }*/



}
