package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {

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

    @Test
    public void testRoomNumbers() {
        //given
        Hotel hotel = new Hotel("Trivago");
        Room room1 = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room1);
        Room room2 = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room2);
        //when

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
        room.addCommodity(bed);
        Toilet toilet = new Toilet();
        room.addCommodity(toilet);
        //when
        InventoryNum bedNum = new InventoryNum(1, 1);
        InventoryNum toiletNum = new InventoryNum(1, 2);
        //then
        assertEquals(bedNum, bed.getInventoryNumber());
        assertEquals(toiletNum, toilet.getInventoryNumber());
    }

}
