import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager("Pesho");
    ArrayList<Room> hotelRooms = new ArrayList<Room>(2);

    @BeforeEach
    void printSomething(){
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.Manager(hotel);
    }

    @Test
    public void managerName() throws Exception{
        assertEquals("Pesho", manager.getName());
        System.out.println("Manager's name is correct!");
    }

    @Test
    public void hotelName() throws Exception{
        assertEquals("Trivago", manager.getHotel());
        System.out.println("Manager's hotel's name is correct!");
    }

    @Test
    public void hotelRooms() throws Exception{
        assertEquals(hotelRooms, manager.getHotelRooms());
        System.out.println("Manager's hotel's rooms are correct!");
    }

    /*@Test
    void checkForFreeRoomsTest2() throws Exception {
        assertTrue(manager.checkForFreeRooms());
        System.out.println("All rooms are unbooked!");
        manager.bookTheFirstAvailableRoom();
        assertTrue(manager.checkForFreeRooms());
        System.out.println("One room is booked!");
        manager.bookTheFirstAvailableRoom();
        assertFalse(manager.checkForFreeRooms());
        System.out.println("All rooms are booked!");
    }*/

}