package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for ManagerClass
 */
class ManagerTest {
    private static Manager manager;
    private LocalDate from = LocalDate.of(2020, 1, 1);
    private LocalDate to = LocalDate.of(2020, 1, 2);

    @BeforeEach
    public void beforeEach() {
        //Manager "Pesho Peshov" with Hotel "Trivago"
        manager = new Manager("Pesho Peshov", new Hotel("Trivago"));
        //Removes all the rooms in the hotel
        manager.getHotel().getRooms().clear();
        //Creates room #1 with 1 single bed
        Room room = new Room(1);
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        //Adds the room to the Hotel
        manager.getHotel().addRoom(room);
    }

    @Test
    public void testManagerName() {
        // given
        String name = "Pesho Peshov";
        //when
        assertEquals(name, manager.getName());
        //then
        System.out.println("Manager's name is correct!");

    }

    @Test
    public void testBookedRoomNum() {
        //given
        //when
        int bookedRoomNum = manager.createBooking("0123456789", from, to, 1);
        //then
        assertEquals(1, bookedRoomNum);
    }

    @Test
    public void testThrowsNoRoomsAvailableExceptionOverlappingDate() {
        //given
        //when
        int i = manager.createBooking("0123456789", from, to, 1);
        //then
        assertEquals(1, i); // The number of the booked toom is 1
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("0123456789", from, to, 1);
        });
    }

    @Test
    public void testThrowsNoRoomsAvailableExceptionCapacityNotMet() {
        //given
        LocalDate from1 = LocalDate.of(2020, 2, 5);
        LocalDate to1 = LocalDate.of(2020, 2, 7);
        //when
        manager.createBooking("0123456789", from, to, 1);
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("0123456789", from1, to1, 2);
        });
    }

    @Test
    public void testIncorrectIntervalException() {
        //given
        LocalDate start = LocalDate.of(2020, 2, 1);
        LocalDate end = LocalDate.of(2020, 1, 2);
        //when
        //then
        assertThrows(IncorrectIntervalException.class, () -> {
            manager.createBooking("id", start, end, 0);
        });
    }
}