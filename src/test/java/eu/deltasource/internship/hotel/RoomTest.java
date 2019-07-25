package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testRoomNumbers() {
        //given
        UniqueRoomNumber rememberLastRoomNum = new UniqueRoomNumber();
        Room room1 = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
        Room room2 = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
        //when
        //then
        assertEquals(1, room1.getNumber());
        assertEquals(2, room2.getNumber());
    }

    @Test
    public void testCreateBooking() {
        //given
        Room room = new Room(1);
        LocalDate from1 = LocalDate.of(2020, 1, 1);
        LocalDate to1 = LocalDate.of(2020, 1, 2);
        LocalDate from2 = LocalDate.of(2020, 1, 5);
        LocalDate to2 = LocalDate.of(2020, 1, 7);
        //when
        room.createBooking("id", from1, to1);
        room.createBooking("id2", from2, to2);
        Booking booking = new Booking("id2", from2, to2);
        //then
        assertEquals(booking, room.getBookings().iterator().next());
        assertEquals(2, room.getBookings().size());
    }

    @Test
    public void testRemoveBooking() {
        //given
        Room room = new Room(1);
        LocalDate from1 = LocalDate.of(2020, 1, 1);
        LocalDate to1 = LocalDate.of(2020, 1, 2);
        //when
        room.createBooking("id", from1, to1);
        room.removeBooking("id", from1, to1);
        //then
        assertEquals(0, room.getBookings().size());
    }

    @Test
    public void testOverlapping() {
        //given
        Room room = new Room(1);
        LocalDate from1 = LocalDate.of(2020, 1, 1);
        LocalDate to1 = LocalDate.of(2020, 1, 2);
        LocalDate from2 = LocalDate.of(2020, 1, 5);
        LocalDate to2 = LocalDate.of(2020, 1, 7);
        room.createBooking("id", from1, to1);
        room.createBooking("id", from2, to2);
        //when
        LocalDate from3 = LocalDate.of(2020, 1, 6);
        LocalDate to3 = LocalDate.of(2020, 1, 6);
        LocalDate from4 = LocalDate.of(2020, 1, 3);
        LocalDate to4 = LocalDate.of(2020, 1, 3);
        //then
        assertTrue(room.doDateOverlap(from3, to3));
        assertFalse(room.doDateOverlap(from4, to4));
    }

    @Test
    public void testCapacity() {
        //given
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        //when
        Bed bed = new Bed(1, BedType.DOUBLE);
        room1.addCommodity(bed);
        //then
        assertEquals(2, room1.getCapacity());
        assertEquals(0, room2.getCapacity());
    }

    @Test
    public void testAddMaintenanceDate() {
        //given
        Room room = new Room(1);
        LocalDate from1 = LocalDate.of(2020, 1, 1);
        //when
        room.addMaintenanceDate(from1);
        //then
        assertEquals(1, room.getMaintenanceDates().size());
        assertEquals(from1, room.getMaintenanceDates().iterator().next());
    }

    @Test
    public void testFindIfAvailable() {
        //given
        Room room = new Room(1);

        LocalDate from1 = LocalDate.of(2020, 1, 1);
        LocalDate to1 = LocalDate.of(2020, 1, 2);

        LocalDate from2 = LocalDate.of(2020, 1, 5);
        LocalDate to2 = LocalDate.of(2020, 1, 7);

        room.createBooking("id", from1, to1);
        room.createBooking("id2", from2, to2);
        //when
        LocalDate from3 = LocalDate.of(2020, 1, 4);
        LocalDate to3 = LocalDate.of(2020, 1, 6);

        LocalDate from4 = LocalDate.of(2020, 1, 3);
        LocalDate to4 = LocalDate.of(2020, 1, 4);
        //then
        assertFalse(room.findIfAvailable(from3, to3, 0));
        assertTrue(room.findIfAvailable(from4, to4, 0));
    }

    @Test
    public void testTimeTravelException() {
        LocalDate from = LocalDate.of(789, 1, 1);
        LocalDate to = LocalDate.of(789, 1, 2);
        //given
        Room room = new Room(1);
        //room with 1 single bed
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        //when
        //then
        assertThrows(TimeTravelException.class, () -> {
            room.createBooking("peter-id", from, to);
        });
    }
}
