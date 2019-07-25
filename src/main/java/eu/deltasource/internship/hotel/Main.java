package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;

import java.time.LocalDate;

/**
 * Main method is here
 */
public class Main {

    public static void main(String args[]) {
        UniqueRoomNumber rememberLastRoomNum = new UniqueRoomNumber();
        UniqueCommodityNumber rememberLastCommodityNum = new UniqueCommodityNumber();
        //Creats a manager "Pesho Peshov" managing Hotel "Trivago"
        Manager manager = new Manager("Pesho Peshov", new Hotel("Trivago"));

        //Creates room#1 with:
        Room room1 = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
        // 1 toilet
        Toilet toilet1 = new Toilet(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room1.addCommodity(toilet1);
        // 1 shower
        Shower shower1 = new Shower(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room1.addCommodity(shower1);
        // 1 DOUBLE bed
        Bed bed1 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.DOUBLE);
        room1.addCommodity(bed1);
        //adds the room to the hotel
        manager.getHotel().addRoom(room1);

        //Creates room#2 with:
        Room room2 = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
        // 2 toilets
        Toilet toilet2 = new Toilet(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room2.addCommodity(toilet2);
        Toilet toilet3 = new Toilet(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room2.addCommodity(toilet3);
        // 1 shower
        Shower shower2 = new Shower(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room2.addCommodity(shower2);
        // 2 SINGLE beds & 1 DOUBLE
        Bed bed2 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.SINGLE);
        room2.addCommodity(bed2);
        Bed bed3 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.SINGLE);
        room2.addCommodity(bed3);
        Bed bed4 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.DOUBLE);
        room2.addCommodity(bed4);
        //adds the room to the hotel
        manager.getHotel().addRoom(room2);


        //Creates room#3 with:
        Room room3 = new Room(rememberLastRoomNum.getRoomNumAndIncrement());
        // 1 toilet
        Toilet toilet4 = new Toilet(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room3.addCommodity(toilet4);
        // 1 shower
        Shower shower3 = new Shower(rememberLastCommodityNum.getCommodityNumAndIncrement());
        room3.addCommodity(shower3);
        // 1 SINGLE bed & 1 DOUBLE
        Bed bed5 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.SINGLE);
        room3.addCommodity(bed5);
        Bed bed6 = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.DOUBLE);
        room3.addCommodity(bed6);
        //adds the room to the hotel
        manager.getHotel().addRoom(room3);

        //manager books room that meets the criteria for 2 guests 20-25Jul
        LocalDate from = LocalDate.of(2020, 7, 20);
        LocalDate to = LocalDate.of(2020, 7, 25);
        int bookedRoomNum = manager.createBooking("9306236677", from, to, 2);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 1 guest 22Jul
        from = LocalDate.of(2020, 7, 22);
        to = LocalDate.of(2020, 7, 22);
        bookedRoomNum = manager.createBooking("8901305687", from, to, 3);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());

        //manager books room that meets the criteria for 2 guests 19-21Jul
        from = LocalDate.of(2020, 7, 19);
        to = LocalDate.of(2020, 7, 21);
        bookedRoomNum = manager.createBooking("9803225785", from, to, 4);
        System.out.println("Room #" + bookedRoomNum + " was booked from: " + from.toString() + " to: " + to.toString());
    }
}