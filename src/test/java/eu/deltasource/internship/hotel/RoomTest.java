package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Room room = new Room(1);
    private LocalDate from1 = LocalDate.of(2020, 1, 1);
    private LocalDate to1 = LocalDate.of(2020, 1, 2);
    private LocalDate from2 = LocalDate.of(2020, 1, 5);
    private LocalDate to2 = LocalDate.of(2020, 1, 7);

    @BeforeEach
    public void beforeEach(){
        room.getBookings().clear();
        room.setCapacity(0);
        room.getMaintenanceDates().clear();
        room.getCommodities().clear();
    }

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
        //when
        room.createBooking("0123456789", from1, to1);
        room.createBooking("0123456789", from2, to2);
        Booking booking = new Booking("0123456789", from2, to2);
        //then
        assertEquals(booking, room.getBookings().iterator().next());
        assertEquals(2, room.getBookings().size());
    }

    @Test
    public void testRemoveBooking() {
        //given
        //when
        room.createBooking("0123456789", from1, to1);
        room.removeBooking("0123456789", from1, to1);
        //then
        assertEquals(0, room.getBookings().size());
    }

    @Test
    public void testOverlapping() {
        //given
        room.createBooking("0123456789", from1, to1);
        room.createBooking("0123456789", from2, to2);
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
        Room room2 = new Room(2);
        //when
        Bed bed = new Bed(1, BedType.DOUBLE);
        room.addCommodity(bed);
        //then
        assertEquals(2, room.getCapacity());
        assertEquals(0, room2.getCapacity());
    }

    @Test
    public void testAddMaintenanceDate() {
        //given
        //when
        room.addMaintenanceDate(from1);
        //then
        assertEquals(1, room.getMaintenanceDates().size());
        assertEquals(from1, room.getMaintenanceDates().iterator().next());
    }

    @Test
    public void testFindIfAvailableOverlapping() {
        //given
        room.createBooking("0123456789", from1, to1);
        room.createBooking("0123456789", from2, to2);
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
    public void testFindIfAvailableCapacity() {
        //given
        room.createBooking("0123456789", from1, to1);
        room.createBooking("0123456789", from2, to2);
        //when
        LocalDate from3 = LocalDate.of(2021, 1, 4);
        LocalDate to3 = LocalDate.of(2021, 1, 6);

        LocalDate from4 = LocalDate.of(2021, 1, 3);
        LocalDate to4 = LocalDate.of(2021, 1, 4);
        //then
        assertFalse(room.findIfAvailable(from3, to3, 3));
        assertTrue(room.findIfAvailable(from4, to4, 0));
    }

    @Test
    public void testTimeTravelException() {
        //given
        LocalDate from = LocalDate.of(789, 1, 1);
        LocalDate to = LocalDate.of(789, 1, 2);
        //room with 1 single bed
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        //when
        //then
        assertThrows(TimeTravelException.class, () -> {
            room.createBooking("0123456789", from, to);
        });
    }

    @Test
    public void testCheckGuestIdThrowsException(){
        //given
        String correct = "0123456789";
        String incorrect1 = "12345678989777";
        String incorrect2 = "0123456c89";
        //when
        //then
        assertDoesNotThrow( () -> {
            room.checkGuestId(correct);
        });
        assertThrows(IncorrectGuestIdException.class, () -> {
            room.checkGuestId(incorrect1);
        });
        assertThrows(IncorrectGuestIdException.class, () -> {
            room.checkGuestId(incorrect2);
        });
    }
}
