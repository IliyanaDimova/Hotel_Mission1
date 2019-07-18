package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;

import java.util.HashSet;

public class RoomTest {

    public void testCreatingARoom() {
        //given
        Manager manager = new Manager("Pesho Peshov");

        Toilet toilet1 = new Toilet(1, 1);


        Room r = new Room(1);
        r.addCommodity(toilet1);

        int roomNumber = r.getRoomNumCount();
        HashSet<AbstractCommodity> commoditySetRoom1 = new HashSet<>();
        commoditySetRoom1.add(toilet1);
        Shower shower1 = new Shower(2, roomNumber);
        commoditySetRoom1.add(shower1);
        Bed bed1 = new Bed(3, BedType.DOUBLE, roomNumber);
        commoditySetRoom1.add(bed1);
        Room room1 = new Room(commoditySetRoom1);


        //when

        //then
    }
}
