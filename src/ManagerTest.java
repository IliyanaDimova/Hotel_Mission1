import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager("Pesho");

    @Before
    void printSomething(){
        System.out.println("Thie is BeforeClass!");
    }

    @Test
    public void managerName() throws Exception{
        assertEquals("Pesho", manager.getName());
    }

    @Test
    void checkForFreeRoomsTest() throws Exception {
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        ArrayList<Room> hotelRooms = new ArrayList<Room>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.Manager(hotel);

        manager.bookTheFirstAvailableRoom();
        manager.bookTheFirstAvailableRoom();
        manager.checkForFreeRooms();
        assertFalse(manager.checkForFreeRooms());
    }

}