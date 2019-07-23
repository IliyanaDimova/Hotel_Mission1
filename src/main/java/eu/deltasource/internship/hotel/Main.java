package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;

import java.time.LocalDate;

/**
 * Main method is here
 */
public class Main {

    public static void main(String args[]) {
        //Creats a manager
        Manager manager = new Manager("Pesho Peshov");
        //Creates new hotel named "Trivago"
        Hotel hotel = new Hotel("Trivago");

        //Creates room#1 with:
        Room room1 = new Room(hotel.getRoomNumCount());
        //adds the room to the hotel
        hotel.addRoom(room1);
        // 1 toilet
        Toilet toilet1 = new Toilet();
        room1.addCommodity(toilet1, hotel);
        // 1 shower
        Shower shower1 = new Shower();
        room1.addCommodity(shower1, hotel);
        // 1 DOUBLE bed
        Bed bed1 = new Bed(BedType.DOUBLE);
        room1.addCommodity(bed1, hotel);

        //Creates room#2 with:
        Room room2 = new Room(hotel.getRoomNumCount());
        //adds the room to the hotel
        hotel.addRoom(room2);
        // 2 toilets
        Toilet toilet2 = new Toilet();
        room2.addCommodity(toilet2, hotel);
        Toilet toilet3 = new Toilet();
        room2.addCommodity(toilet3, hotel);
        // 1 shower
        Shower shower2 = new Shower();
        room2.addCommodity(shower2, hotel);
        // 2 SINGLE beds & 1 DOUBLE
        Bed bed2 = new Bed(BedType.SINGLE);
        room2.addCommodity(bed2, hotel);
        Bed bed3 = new Bed(BedType.SINGLE);
        room2.addCommodity(bed3, hotel);
        Bed bed4 = new Bed(BedType.DOUBLE);
        room2.addCommodity(bed4, hotel);


        //Creates room#3 with:
        Room room3 = new Room(hotel.getRoomNumCount());
        //adds the room to the hotel
        hotel.addRoom(room3);
        // 1 toilet
        Toilet toilet4 = new Toilet();
        room3.addCommodity(toilet4, hotel);
        // 1 shower
        Shower shower3 = new Shower();
        room3.addCommodity(shower3, hotel);
        // 1 SINGLE bed & 1 DOUBLE
        Bed bed5 = new Bed(BedType.SINGLE);
        room3.addCommodity(bed5, hotel);
        Bed bed6 = new Bed(BedType.DOUBLE);
        room3.addCommodity(bed6, hotel);

        //Adds the hotel to the manager
        manager.assignHotel(hotel);

        //manager books room that meets the criteria for 2 guests 20-25Jul
        LocalDate from = LocalDate.parse("2019-07-20"); // Converts string to LocalDate
        LocalDate to = LocalDate.parse("2019-07-25");
        int bookedRoomNum = manager.createBooking("9306236677", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 1 guest 22Jul
        from = LocalDate.parse("2019-07-22");
        to = LocalDate.parse("2019-07-22");
        bookedRoomNum = manager.createBooking("8901305687", from, to, 1);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 2 guests 19-21Jul
        from = LocalDate.parse("2019-07-19");
        to = LocalDate.parse("2019-07-21");
        bookedRoomNum = manager.createBooking("9803225785", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());
    }
}