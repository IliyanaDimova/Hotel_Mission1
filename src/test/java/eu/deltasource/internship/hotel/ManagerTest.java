package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Hotel hotel = new Hotel();
        //when
        manager.setHotel(hotel);
        assertEquals(hotel, manager.getHotel());
        //then
        System.out.println("main.java.eu.deltasource.internship.hotel.domain.Manager's hotel is correct!");
    }

    @Test
    public void assure() {
        // given
        Hotel hotel = new Hotel();
        //when
        manager.setHotel(hotel);
        assertEquals(hotel, manager.getHotel());
        //then
        System.out.println("main.java.eu.deltasource.internship.hotel.domain.Manager's hotel is correct!");
    }

    @Test
    public void assurePerfectRoomIsReturned() {
        //Creates room1 with 1 toilet, 1 shower and 1 bed (for 2 people)
        int roomNumber = 001;
        ArrayList<AbstractCommodity> commoditySetRoom1 = new ArrayList<>();
        Toilet toilet1 = new Toilet(1, roomNumber);
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2, roomNumber);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, 2, roomNumber);
        commoditySetRoom1.add(bed1);
        Room room1 = new Room(roomNumber, commoditySetRoom1);

        //Creates room1 with 2 toilet, 1 shower and 3 beds(2*(for 1 person) & 1*(for 2 people))
        roomNumber = 002;
        ArrayList<AbstractCommodity> commoditySetRoom2 = new ArrayList<>();
        Toilet toilet2 = new Toilet(4, roomNumber);
        commoditySetRoom1.add(toilet2);
        Toilet toilet3 = new Toilet(5, roomNumber);
        commoditySetRoom1.add(toilet3);
        Shower shower2 = new Shower(6, roomNumber);
        commoditySetRoom1.add(shower2);
        Bed bed2 = new Bed(7, 2, roomNumber);
        commoditySetRoom1.add(bed2);
        Bed bed3 = new Bed(8, 1, roomNumber);
        commoditySetRoom1.add(bed3);
        Bed bed4 = new Bed(9, 1, roomNumber);
        commoditySetRoom1.add(bed4);
        Room room2 = new Room(roomNumber, commoditySetRoom2);

        //Creates room1 with 1 toilet, 1 shower and 2 beds(1*(for 1 person) + 1*(for 2 people))
        roomNumber = 003;
        ArrayList<AbstractCommodity> commoditySetRoom3 = new ArrayList<>();
        Toilet toilet4 = new Toilet(10, roomNumber);
        commoditySetRoom1.add(toilet4);
        Shower shower3 = new Shower(11, roomNumber);
        commoditySetRoom1.add(shower3);
        Bed bed5 = new Bed(12, 2, roomNumber);
        commoditySetRoom1.add(bed5);
        Bed bed6 = new Bed(13, 1, roomNumber);
        commoditySetRoom1.add(bed6);
        Room room3 = new Room(roomNumber, commoditySetRoom3);

        //Adds the rooms to the hotel and then the hotel to the manager
        ArrayList<Room> hotelRooms = new ArrayList<>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        hotelRooms.add(room3);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.setHotel(hotel);

        assertEquals(2, room1.countSleepingPlaces());
        System.out.println("Number of sleeping places is working!");

        String stringFrom1 = "2019-07-20";
        String stringTo1 = "2019-07-25";
        Room perfectRoomForGuest1;
        perfectRoomForGuest1 = manager.findPerfectFitRoom(stringFrom1, stringTo1, 2);
        assertEquals(perfectRoomForGuest1, room1);
        System.out.println("Perfect Fit main.java.eu.deltasource.internship.hotel.domain.Room Is Working!");
    }

}