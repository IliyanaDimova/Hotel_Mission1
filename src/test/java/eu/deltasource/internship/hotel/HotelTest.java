package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    private static Hotel hotel = new Hotel("Trivago");

    @BeforeEach
    public void beforeEach() {
        hotel.getRooms().clear();
    }

    @Test
    public void testaddRooms() {
        //given
        UniqueRoomNumber roomNum = new UniqueRoomNumber();
        //when
        hotel.addRooms(101, roomNum);
        //then
        assertEquals(101, hotel.getRooms().size());
        assertTrue(hotel.getRooms().containsKey(101));
        assertFalse(hotel.getRooms().containsKey(102));
    }

    //Incorrect
    @Test
    public void testAddSameCommodityForAllRooms() {
        //given
        UniqueRoomNumber roomNum = new UniqueRoomNumber();
        hotel.addRooms(5, roomNum);
        //when
        Shower shower = new Shower(1);
        hotel.addSameCommodityToEveryRoom(shower);
        //then
        System.out.println(hotel.getRooms().get(3).getCommodities().iterator().next());
        Shower s = new Shower(3);
        assertEquals(s, hotel.getRooms().get(3).getCommodities().iterator().next());
    }

    @Test
    public void testFindAvailableRooms() {
        //given
        Room room = new Room(hotel.getRoomNumCount());
        Bed bed = new Bed(1, BedType.SINGLE);
        room.addCommodity(bed);
        hotel.addRoom(room);
        //when
        LocalDate from = LocalDate.of(2020, 1, 1);
        LocalDate to = LocalDate.of(2020, 1, 2);
        //then
        assertEquals(room, hotel.findAvailableRooms(from, to, 1).iterator().next());
        assertEquals(0, hotel.findAvailableRooms(from, to, 2).size());
    }
}
