import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests
 */
class ManagerTest {
    private static Manager manager = new Manager("Pesho Peshov");

    /**
     * Fills in data in manager class - hotel with 1 room
     * Shows if manager's data is filled in correctly in the classes fields
     */
    /*@BeforeClass
    public static void assureManagerHotelRoomsAreCorrect() {
        System.out.println("@BeforeClass Assure Manager Hotel Rooms Are Correct");

        //Creates room1 with 1 toilet, 1 shower and 1 bed (for 2 people)
        HashSet<AbstractCommodity> commoditySetRoom1 = new HashSet<>();
        Toilet toilet1 = new Toilet(1);
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, 2);
        commoditySetRoom1.add(bed1);
        Room room1 = new Room(1, commoditySetRoom1);

        //Adds the rooms to the hotel and then the hotel to the manager
        ArrayList<Room> hotelRooms = new ArrayList<>(2);
        hotelRooms.add(room1);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.setHotel(hotel);

        assertEquals("Pesho Peshov", manager.getName());
        System.out.println("Manager's name is correct!");
        assertEquals("Trivago", manager.getHotel());
        System.out.println("Manager's hotel is correct!");
        assertEquals(hotelRooms, hotel.getRooms());
        System.out.println("Hotel's rooms are correct!");
        assertEquals(1, hotel.getRooms().get(0).getNumber());
        System.out.println("Room's number is correct!");
        assertEquals(commoditySetRoom1, hotel.getRooms().get(0).getCommoditySet());
        System.out.println("Room's commodity set is correct!");
        assertEquals(room1.getMaintenanceDates(), hotel.getRooms().get(0).getMaintenanceDates());
        System.out.println("Room's MaintenanceDates are correct!");
        assertEquals(room1.getBookings(), hotel.getRooms().get(0).getBookings());
        System.out.println("Room's Bookings are correct!");
    }*/

    @Test
    public void assureStringToLocalDateWorks() {

        assertEquals("2019-07-20", manager.stringToLocalDate("2019-07-20").toString());
        System.out.println("LocalDate to String is working!");
    }

    //I don't know why but I BeforeClass doesn't run D:
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
        System.out.println("Perfect Fit Room Is Working!");
    }

}