package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * main.java.eu.deltasource.internship.hotel.Main method is here
 */
public class Main {

    /*public static void main(String args[]) {
        //Creats a manager
        Manager manager = new Manager("Pesho Peshov");

        //Creates new hotel named "Trivago"
        Hotel hotel = new Hotel();
        hotel.setName("Trivago");

        new Bed(1, BedType.KINGSIZE, 1);
        //Creates room#1 with:
        // 1 toilet
        // 1 shower
        // 1 DOUBLE bed
        Room room = new Room();
        Toilet toilet1 = new Toilet(1, roomNumber);
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2, roomNumber);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, BedType.DOUBLE, roomNumber);
        commoditySetRoom1.add(bed1);

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

        //manager books room that meets the criteria for 2 guests 20-25Jul
        LocalDate from = manager.stringToLocalDate("2019-07-20"); // Converts string to LocalDate
        LocalDate to = manager.stringToLocalDate("2019-07-25");
        int bookedRoomNum = manager.createBooking("9306236677", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 1 guest 22Jul
        from = manager.stringToLocalDate("2019-07-22");
        to = manager.stringToLocalDate("2019-07-22");
        bookedRoomNum = manager.createBooking("8901305687", from, to, 1);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 2 guests 19-21Jul
        from = manager.stringToLocalDate("2019-07-19");
        to = manager.stringToLocalDate("2019-07-21");
        bookedRoomNum = manager.createBooking("9803225785", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

    }*/
}