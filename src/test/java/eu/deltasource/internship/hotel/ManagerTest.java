package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ManagerClass
 */
class ManagerTest {
    private static Manager manager = new Manager("Pesho Peshov");

    @Test
    public void assureStringToLocalDateWorks() {
        // given
        String stringDate = "2019-07-20";
        //when
        assertEquals(stringDate, manager.stringToLocalDate("2019-07-20").toString());
        //then
        System.out.println("LocalDate to String is working!");

    }

    @Test
    public void assureManagerNameIsCorrect() {
        // given
        String name = "Pesho Peshov";
        //when
        assertEquals(name, manager.getName());
        //then
        System.out.println("Manager's name is correct!");

    }

    @Test
    public void testScenarioOne() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        Bed bed = new Bed(BedType.DOUBLE);
        room.addCommodity(bed);
        //when
        LocalDate from = manager.stringToLocalDate("2019-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2019-01-02");
        int bookedRoomNum = manager.createBooking("peter-id", from, to, 2);
        //then
        assertEquals(bookedRoomNum, 1);
    }

    @Test
    public void testScenarioTwo() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        manager.assignHotel(hotel);
        //when
        LocalDate from = manager.stringToLocalDate("2019-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2019-01-02");
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from, to, 2);
        });
    }

    @Test
    public void testScenarioTree() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed);
        //when
        LocalDate from = manager.stringToLocalDate("2019-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2019-01-02");
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from, to, 2);
        });
    }

}