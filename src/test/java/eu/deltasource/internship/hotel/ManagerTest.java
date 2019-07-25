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
    //private static Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
    //private LocalDate from = LocalDate.of(2020, 1, 1);
    //private LocalDate to = LocalDate.of(2020, 1, 2);

    @Test
    public void assureManagerNameIsCorrect() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        // given
        String name = "Pesho Peshov";
        //when
        assertEquals(name, manager.getName());
        //then
        System.out.println("Manager's name is correct!");

    }

    @Test
    public void testScenarioOne() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        Room room = new Room(1);
        manager.getHotel().addRoom(room);
        Bed bed = new Bed(1, BedType.DOUBLE);
        room.addCommodity(bed);
        //when
        int bookedRoomNum = manager.createBooking("peter-id", from, to, 2);
        //then
        assertEquals(bookedRoomNum, 1);
    }

    @Test
    public void testScenarioTwo() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        //when
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from, to, 2);
        });
    }

    @Test
    public void testScenarioTree() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        //Manager manager = new Manager("Pesho");
        //Hotel hotel = new Hotel("Trivago");
        Room room = new Room(1);
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        manager.getHotel().addRoom(room);
        //when
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from, to, 2);
        });
    }

    @Test
    public void testManyBookingsOnDifferentDate() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        Room room = new Room(1);
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        manager.getHotel().addRoom(room);
        //when
        int i = manager.createBooking("peter-id", from, to, 1);

        LocalDate from1 = LocalDate.of(2020, 2, 1);
        LocalDate to1 = LocalDate.of(2020, 2, 2);
        //then
        assertEquals(1, i); // The number of the booked toom is 1
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("peter-id", from1, to1, 2);
        });
    }

    @Test
    public void testManyBookingsThrowsOnSameDate() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        Room room = new Room(1);
        manager.getHotel().addRoom(room);
        //room with 1 single bed
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        //when
        manager.createBooking("peter-id", from, to, 1);

        LocalDate from1 = LocalDate.of(2020, 1, 2);
        LocalDate to1 = LocalDate.of(2020, 2, 2);
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("katya-id", from1, to1, 1);
        });
    }

    @Test
    public void testAddCommodities() {
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //given
        Room room = new Room(1);
        //room with 1 single bed
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        manager.getHotel().addRoom(room);
        //when
        manager.createBooking("peter-id", from, to, 1);
        LocalDate from1 = LocalDate.of(2020, 1, 2);
        LocalDate to1 = LocalDate.of(2020, 2, 2);
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("katya-id", from1, to1, 1);
        });
    }
}