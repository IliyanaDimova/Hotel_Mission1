package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
/*
    @Test
    public void testRoomNumbers() {
        //given
        Hotel hotel = new Hotel("Trivago");
        //when
        hotel.addRooms(121);
        int i = 1;
        //then
        for (Room room : hotel.getRooms()) {
            assertEquals(i, room.getNumber());
            i++;
        }
    }

    @Test
    public void testCommodityInventoryNumbers() {
        //given
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        Toilet toilet = new Toilet();
        room.addCommodity(toilet, hotel);
        Room room1 = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room1);
        Shower shower = new Shower();
        room1.addCommodity(shower, hotel);
        //when
        int bedNum = 1;
        int toiletNum = 2;
        int showerNum = 3;
        //then
        assertEquals(bedNum, bed.getInventoryNumber());
        assertEquals(toiletNum, toilet.getInventoryNumber());
        assertEquals(showerNum, shower.getInventoryNumber());
    }

    @Test
    public void testDoDateOverlap() {
        //given
        Room room = new Room();
        LocalDate from = LocalDate.parse("2020-01-01");
        LocalDate to = LocalDate.parse("2020-01-02");
        LocalDate from1 = LocalDate.parse("2020-01-05");
        LocalDate to1 = LocalDate.parse("2020-01-06");
        room.createBooking("id", from, to);
        room.createBooking("id", from1, to1);
        //when
        LocalDate from2 = LocalDate.parse("2020-01-01");
        LocalDate to2 = LocalDate.parse("2020-01-02");
        LocalDate from3 = LocalDate.parse("2020-01-03");
        LocalDate to3 = LocalDate.parse("2020-01-03");
        //then
        assertTrue(room.doDateOverlap(from2, to2));
        assertFalse(room.doDateOverlap(from3, to3));
    }

    @Test
    public void testCountSleepingPlaces() {
        //given
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        Room room1 = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room1);
        //when
        Bed bed = new Bed(BedType.DOUBLE);
        room.addCommodity(bed, hotel);
        //then
        assertEquals(2, room.getCapacity());
        assertEquals(0, room1.getCapacity());
    }

    @Test
    public void testRemoveBooking() {
        //given
        Room room = new Room();
        Manager manager = new Manager("Pesho");
        LocalDate from = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        //when
        room.createBooking("id", from, to);
        room.removeBooking("id", from, to);
        //then
        assertEquals(0, room.getBookings().size());
    }

    @Test
    public void testAddMaintenanceDate() {
        //given
        Room room = new Room();
        Manager manager = new Manager("Pesho");
        LocalDate date = LocalDate.parse("2020-01-01"); // Converts string to LocalDate
        //when
        room.addMaintenanceDate(date);
        //then
        assertEquals(1, room.getMaintenanceDates().size());
        assertEquals(date, room.getMaintenanceDates().iterator().next());
    }

    @Test
    public void testCreateBooking() {
        //given
        Room room = new Room();
        LocalDate from = LocalDate.parse("2020-01-01");
        LocalDate to = LocalDate.parse("2020-01-02");
        //when
        room.createBooking("id", from, to);
        room.createBooking("id2", from, to);
        Booking booking = new Booking("id2", from, to);
        //then
        assertEquals(booking, room.getBookings().iterator().next());
        assertEquals(2, room.getBookings().size());
    }

    @Test
    public void testCreateBookingException() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room();
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        //room with 1 single bed
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = LocalDate.parse("2019-01-01"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2020-01-02");
        //then
        assertThrows(TimeTravelException.class, () -> {
            manager.createBooking("peter-id", from, to, 1);
        });
    }

    @Test
    public void addCommodityException() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room();
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        //when
        Toilet toilet = new Toilet();
        room.addCommodity(toilet, hotel);
        //then
        assertThrows(CommodityAlreadyBelongsToRoomException.class, () -> {
            room.addCommodity(toilet, hotel);
        });
    }

    @Test
    public void testFindIfAvailable() {
        //given
        Room room = new Room();

        LocalDate from = LocalDate.parse("2020-01-01");
        LocalDate to = LocalDate.parse("2020-01-02");

        LocalDate from1 = LocalDate.parse("2020-01-05");
        LocalDate to1 = LocalDate.parse("2020-01-07");

        room.createBooking("id", from, to);
        room.createBooking("id2", from1, to1);
        //when
        LocalDate from2 = LocalDate.parse("2020-01-04");
        LocalDate to2 = LocalDate.parse("2020-01-06");

        LocalDate from3 = LocalDate.parse("2020-01-03");
        LocalDate to3 = LocalDate.parse("2020-01-04");
        //then
        assertFalse(room.findIfAvailable(from2, to2, 0));
        assertTrue(room.findIfAvailable(from3, to3, 0));
    }

    @Test
    public void testCapacity() {
        //given
        Hotel hotel = new Hotel("Trivago");
        hotel.addRooms(1);
        //when
        hotel.getRooms().iterator().next().addCommodity(new Bed(BedType.KINGSIZE), hotel);
        hotel.getRooms().iterator().next().addCommodity(new Bed(BedType.SINGLE), hotel);
        hotel.getRooms().iterator().next().addCommodity(new Bed(BedType.DOUBLE), hotel);
        //then
        assertEquals(5, hotel.getRooms().iterator().next().getCapacity());
    }*/
}
