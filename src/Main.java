import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) throws ParseException {
        Manager manager = new Manager("Pesho Peshov");

        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);

        HashSet<AbstractCommodity> commoditySetRoom1 = new HashSet<>();
        Toilet toilet1 = new Toilet();
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower();
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed();
        bed1.setNumberOfPersonas(2);
        commoditySetRoom1.add(bed1);
        room1.setCommoditySet(commoditySetRoom1);

        HashSet<AbstractCommodity> commoditySetRoom2 = new HashSet<>();
        Toilet toilet2 = new Toilet();
        commoditySetRoom1.add(toilet2);
        Toilet toilet3 = new Toilet();
        commoditySetRoom1.add(toilet3);
        Shower shower2 = new Shower();
        commoditySetRoom1.add(shower2);
        Bed bed2 = new Bed();
        bed2.setNumberOfPersonas(2);
        commoditySetRoom1.add(bed2);
        Bed bed3 = new Bed();
        bed3.setNumberOfPersonas(1);
        commoditySetRoom1.add(bed3);
        Bed bed4 = new Bed();
        bed4.setNumberOfPersonas(1);
        commoditySetRoom1.add(bed4);
        room1.setCommoditySet(commoditySetRoom2);

        HashSet<AbstractCommodity> commoditySetRoom3 = new HashSet<>();
        Toilet toilet4 = new Toilet();
        commoditySetRoom1.add(toilet4);
        Shower shower3 = new Shower();
        commoditySetRoom1.add(shower3);
        Bed bed5 = new Bed();
        bed5.setNumberOfPersonas(2);
        commoditySetRoom1.add(bed5);
        Bed bed6 = new Bed();
        bed6.setNumberOfPersonas(1);
        commoditySetRoom1.add(bed6);
        room1.setCommoditySet(commoditySetRoom3);

        ArrayList<Room> hotelRooms = new ArrayList<Room>(2);
        hotelRooms.add(room1);
        hotelRooms.add(room2);
        hotelRooms.add(room3);
        Hotel hotel = new Hotel("Trivago", hotelRooms);
        manager.Manager(hotel);

        Room perfectRoomForGuest1 = new Room();
        perfectRoomForGuest1 = manager.findPerfectFitRoomOrReturnNull("2019/07/20", "2019/07/25", 1, 0);
        if(perfectRoomForGuest1!=null){
            if(perfectRoomForGuest1.bookRoomForInterval("2019/07/20", "2019/07/25", "Viktor Petrovich", "6506035522")){
                System.out.println("Room #" + perfectRoomForGuest1.getNumber() + " is booked");
            }
        }

        Room perfectRoomForGuest2 = new Room();
        perfectRoomForGuest2 = manager.findPerfectFitRoomOrReturnNull("2019/07/22", "2019/07/22", 0, 1);
        if(perfectRoomForGuest2!=null){
            if(perfectRoomForGuest2.bookRoomForInterval("2019/07/22", "2019/07/22", "Eliza Stanford", "8604024411")){
                System.out.println("Room #" + perfectRoomForGuest2.getNumber() + " is booked");
            }
        }

        Room perfectRoomForGuest3 = new Room();
        perfectRoomForGuest3 = manager.findPerfectFitRoomOrReturnNull("2019/07/19", "2019/07/21", 0, 2);
        if(perfectRoomForGuest3!=null){
            if(perfectRoomForGuest3.bookRoomForInterval("2019/07/19", "2019/07/21", "Todor Georgiev", "8511053318")){
                System.out.println("Room #" + perfectRoomForGuest3.getNumber() + " is booked");
            }
        }

    }
}