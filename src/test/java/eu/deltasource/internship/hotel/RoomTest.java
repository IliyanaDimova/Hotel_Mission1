package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {

    @Test
    public void testRoomNumbers() {
        //given
        Hotel hotel = new Hotel("Trivago");
        Room room1 = new Room(hotel.getRoomNumCount());
        Room room2 = new Room(hotel.getRoomNumCount());
        //when
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        //then
        assertEquals(1, room1.getNumber());
        assertEquals(2, room2.getNumber());
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
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        Bed bed = new Bed(BedType.DOUBLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = manager.stringToLocalDate("2020-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2020-01-02");
        LocalDate from2 = manager.stringToLocalDate("2020-01-02"); // Converts string to LocalDate
        LocalDate to2 = manager.stringToLocalDate("2020-01-02");
        manager.createBooking("peter-id", from, to, 2);
        //then
        assertThrows(NoRoomsAvailableException.class, () -> {
            manager.createBooking("katya-id", from2, to2, 2);
        });
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
        assertEquals(2, room.countSleepingPlaces());
        assertEquals(0, room1.countSleepingPlaces());
    }

    @Test
    public void testCreateBooking() {
        //given
        Room room = new Room();
        Manager manager = new Manager("Pesho");
        LocalDate from = manager.stringToLocalDate("2020-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2020-01-02");
        //when
        room.createBooking("id", from, to);
        //then
        assertEquals(1, room.getBookings().size());
    }

    @Test
    public void testRemoveBooking() {
        //given
        Room room = new Room();
        Manager manager = new Manager("Pesho");
        LocalDate from = manager.stringToLocalDate("2020-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2020-01-02");
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
        LocalDate date = manager.stringToLocalDate("2020-01-01"); // Converts string to LocalDate
        //when
        room.addMaintenanceDate(date);
        //then
        assertEquals(1, room.getMaintenanceDates().size());
        assertEquals(date, room.getMaintenanceDates().iterator().next());
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
        LocalDate from = manager.stringToLocalDate("2019-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2020-01-02");
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
}
