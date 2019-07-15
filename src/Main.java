import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) {
        Manager manager = new Manager("Pesho Peshov");

        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);

        //Creates room1 with 1 toilet, 1 shower and 1 bed(1 persona)
        HashSet<AbstractCommodity> commoditySetRoom1 = new HashSet<>();
        Toilet toilet1 = new Toilet(1);
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, 1);
        commoditySetRoom1.add(bed1);
        room1.setCommoditySet(commoditySetRoom1);

        //Creates room1 with 2 toilet, 1 shower and 3 beds(2*(1 persona) & 1*(2 persona))
        HashSet<AbstractCommodity> commoditySetRoom2 = new HashSet<>();
        Toilet toilet2 = new Toilet(4);
        commoditySetRoom1.add(toilet2);
        Toilet toilet3 = new Toilet(5);
        commoditySetRoom1.add(toilet3);
        Shower shower2 = new Shower(6);
        commoditySetRoom1.add(shower2);
        Bed bed2 = new Bed(7, 2);
        commoditySetRoom1.add(bed2);
        Bed bed3 = new Bed(8, 1);
        commoditySetRoom1.add(bed3);
        Bed bed4 = new Bed(9, 1);
        commoditySetRoom1.add(bed4);
        room1.setCommoditySet(commoditySetRoom2);

        //Creates room1 with 1 toilet, 1 shower and 2 beds(1*(1 persona) + 1*(2 persona))
        HashSet<AbstractCommodity> commoditySetRoom3 = new HashSet<>();
        Toilet toilet4 = new Toilet(10);
        commoditySetRoom1.add(toilet4);
        Shower shower3 = new Shower(11);
        commoditySetRoom1.add(shower3);
        Bed bed5 = new Bed(12, 2);
        commoditySetRoom1.add(bed5);
        Bed bed6 = new Bed(13, 1);
        commoditySetRoom1.add(bed6);
        room1.setCommoditySet(commoditySetRoom3);

        //Adds the rooms to the hotel and then the hotel to the manager
        ArrayList<Room> hotelRooms = new ArrayList<>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        hotelRooms.add(room3);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.managerAssignHotel(hotel);

        String stringFrom1 = "2019-07-20";
        String stringTo1 = "2019-07-25";
        Room perfectRoomForGuest1;
        perfectRoomForGuest1 = manager.findPerfectFitRoomOrReturnNull(stringFrom1, stringTo1, 2);
        if (perfectRoomForGuest1 != null) {
            if (perfectRoomForGuest1.bookRoomForInterval(stringFrom1, stringTo1, "Viktor Petrovich", "6506035522")) {
                System.out.println("Room #" + perfectRoomForGuest1.getNumber() + " is booked");
            }
        }

        String stringFrom2 = "2019-07-22";
        String stringTo2 = "2019-07-22";
        Room perfectRoomForGuest2;
        perfectRoomForGuest2 = manager.findPerfectFitRoomOrReturnNull(stringFrom2, stringTo2, 1);
        if (perfectRoomForGuest2 != null) {
            if (perfectRoomForGuest2.bookRoomForInterval(stringFrom2, stringTo2, "Eliza Stanford", "8604024411")) {
                System.out.println("Room #" + perfectRoomForGuest2.getNumber() + " is booked");
            }
        }

        String stringFrom3 = "2019-07-19";
        String stringTo3 = "2019-07-21";
        Room perfectRoomForGuest3;
        perfectRoomForGuest3 = manager.findPerfectFitRoomOrReturnNull(stringFrom3, stringTo3, 2);
        if (perfectRoomForGuest3 != null) {
            if (perfectRoomForGuest3.bookRoomForInterval(stringFrom3, stringTo3, "Todor Georgiev", "8511053318")) {
                System.out.println("Room #" + perfectRoomForGuest3.getNumber() + " is booked");
            }
        }

    }
}