package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests
 */
class ManagerTest {
    private static Manager manager = new Manager("Pesho Peshov");

    @Test
    public void assureStringToLocalDateWorks() {
        // given
        String stringDate = "2019-07-20";
        //when
        assertEquals(stringDate, manager.stringToLocalDate("2019-07-20").toString());
        //then
        System.out.println("LocalDate to String is working!");

    }

    @Test
    public void assureManagerNameIsCorrect() {
        // given
        String name = "Pesho Peshov";
        //when
        assertEquals(name, manager.getName());
        //then
        System.out.println("main.java.eu.deltasource.internship.hotel.domain.Manager's name is correct!");

    }

    @Test
    public void assureManagerHotelIsCorrect() {
        // given
        Hotel hotel = new Hotel("test");

        //when
        manager.setHotel(hotel);

        //then
        assertThat("Manager's hotel is incorrect!" , hotel, equalTo(manager.getHotel()));
    }

    @Test
    public void assureManagersHotelIsCorrect() {
        // given
        Hotel hotel = new Hotel("Name");

        //when
        manager.setHotel(hotel);

        //then
        assertThat("Manager's hotel is incorrect!" , hotel, equalTo(manager.getHotel()));
    }

    @Test
    public void assurePerfectRoomIsReturned() {
        //Creates room#001 with:
        // 1 toilet
        // 1 shower
        // 1 bed (for 2 people)
        Room r = new Room(null);
        int roomNumber = r.getRoomNumCount();
        HashSet<AbstractCommodity> commoditySetRoom1 = new HashSet<>();
        Toilet toilet1 = new Toilet(1, roomNumber);
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2, roomNumber);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, BedType.DOUBLE, roomNumber);
        commoditySetRoom1.add(bed1);
        Room room1 = new Room(commoditySetRoom1);

        //Creates room#002 with:
        // 2 toilet
        // 1 shower
        // 3 beds(2*(for 1 person) & 1*(for 2 people))
        roomNumber = room1.getRoomNumCount();
        HashSet<AbstractCommodity> commoditySetRoom2 = new HashSet<>();
        Toilet toilet2 = new Toilet(4, roomNumber);
        commoditySetRoom1.add(toilet2);
        Toilet toilet3 = new Toilet(5, roomNumber);
        commoditySetRoom1.add(toilet3);
        Shower shower2 = new Shower(6, roomNumber);
        commoditySetRoom1.add(shower2);
        Bed bed2 = new Bed(7, BedType.DOUBLE, roomNumber);
        commoditySetRoom1.add(bed2);
        Bed bed3 = new Bed(8, BedType.SINGLE, roomNumber);
        commoditySetRoom1.add(bed3);
        Bed bed4 = new Bed(9, BedType.SINGLE, roomNumber);
        commoditySetRoom1.add(bed4);
        Room room2 = new Room(commoditySetRoom2);

        //Creates room#003 with:
        // 1 toilet
        // 1 shower
        // 2 beds(1*(for 1 person) + 1*(for 2 people))
        roomNumber = 003;
        HashSet<AbstractCommodity> commoditySetRoom3 = new HashSet<>();
        Toilet toilet4 = new Toilet(10, roomNumber);
        commoditySetRoom1.add(toilet4);
        Shower shower3 = new Shower(11, roomNumber);
        commoditySetRoom1.add(shower3);
        Bed bed5 = new Bed(12, BedType.DOUBLE, roomNumber);
        commoditySetRoom1.add(bed5);
        Bed bed6 = new Bed(13, BedType.SINGLE, roomNumber);
        commoditySetRoom1.add(bed6);
        Room room3 = new Room(commoditySetRoom3);

        //Adds the rooms to the hotel
        ArrayList<Room> hotelRooms = new ArrayList<>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        hotelRooms.add(room3);
        Hotel hotel = new Hotel("Trivago", hotelRooms);

        //Adds the hotel to the manager
        manager.assignHotel(hotel);

        assertEquals(2, room1.countSleepingPlaces());
        System.out.println("Number of sleeping places is working!");

        //manager books room that meets the criteria for 2 guests 20-25Jul
        LocalDate from = manager.stringToLocalDate("2019-07-20"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2019-07-25");
        int bookedRoomNum = manager.createBooking("9306236677", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

    }

}