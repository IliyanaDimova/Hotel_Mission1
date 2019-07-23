package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    @Test
    public void testaddRooms() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        manager.assignHotel(hotel);
        //when
        hotel.addRooms(101);
        //then
        assertEquals(101, hotel.getRooms().size());
    }

    @Test
    public void testAddSameCommodityForAllRooms() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        //when
        Shower shower = new Shower();
        hotel.addSameCommodityToEveryRoom(shower);
        //then
        assertEquals(shower, room.getCommodities().iterator().next());
    }

    @Test
    public void testAddRoom() {
        //given
        Hotel hotel = new Hotel("Trivago");
        //when
        hotel.addRoom(new Room());
        //then
        assertEquals(1, hotel.getRooms().iterator().next().getNumber());
    }

    @Test
    public void testFindAvailableRooms() {
        //given
        Manager manager = new Manager("Pesho");
        Hotel hotel = new Hotel("Trivago");
        Room room = new Room(hotel.getRoomNumCount());
        hotel.addRoom(room);
        manager.assignHotel(hotel);
        Bed bed = new Bed(BedType.SINGLE);
        room.addCommodity(bed, hotel);
        //when
        LocalDate from = manager.stringToLocalDate("2020-01-01"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2020-01-02");
        //then
        assertEquals(room, hotel.findAvailableRooms(from, to, 1).iterator().next());
        assertEquals(0, hotel.findAvailableRooms(from, to, 2).size());
    }
}
