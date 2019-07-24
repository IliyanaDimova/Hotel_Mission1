package eu.deltasource.internship.hotel.domain;

/**
 * Has a static field that contains integer that knows the last initialized room's number
 */
public class UniqueRoomNumber {
    private static int roomNum;

    public UniqueRoomNumber(){
        roomNum = 0;
    }

    public int getRoomNumAndIncrement(){
        roomNum++;
        return roomNum;
    }
}
