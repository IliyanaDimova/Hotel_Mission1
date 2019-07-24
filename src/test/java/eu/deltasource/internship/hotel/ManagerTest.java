package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for ManagerClass
 */
class ManagerTest {
    /*
    private static Manager manager = new Manager("Pesho Peshov");

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
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
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
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
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
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from, to, 2);
        });
    }

    @Test
    public void testManyBookingsOnDifferentDate() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        int i = manager.createBooking("peter-id", from, to, 1);
        LocalDate from1 = LocalDate.parse("2020-02-01"); // Converts string to LocalDate
        LocalDate to1 = LocalDate.parse("2020-02-02");
        //then
        assertEquals(1, i); // The number of the booked toom is 1
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from1, to1, 2);
        });
    }

    @Test
    public void testManyBookingsThrowsOnSameDate() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        //room with 1 single bed
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        manager.createBooking("peter-id", from, to, 1);
        LocalDate from1 = LocalDate.parse("2020-01-02"); // Converts string to LocalDate
        LocalDate to1 = LocalDate.parse("2020-02-02");
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
           manager.createBooking("katya-id", from1, to1, 1);
        });
    }

    @Test
    public void testAddCommodities() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        //room with 1 single bed
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        manager.createBooking("peter-id", from, to, 1);
        LocalDate from1 = LocalDate.parse("2020-01-02"); // Converts string to LocalDate
        LocalDate to1 = LocalDate.parse("2020-02-02");
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("katya-id", from1, to1, 1);
        });
    }*/
}