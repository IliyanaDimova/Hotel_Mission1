import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    ArrayList<Room> numberOfAvailableRooms(Hotel this) {
        ArrayList<Room> avaliableRooms = new ArrayList<Room>();
        for (int i = 0; i < this.rooms.size(); i++)
        {
            if(!this.rooms.get(i).checkIfBooked()) {
                avaliableRooms.add(this.rooms.get(i));
            }
        }
        return avaliableRooms;
    }

    int hotelNumberOfRooms(Hotel hotel){
        return hotel.rooms.size();
    }

    void clearEachRoom(int currentRoomInList){
        this.rooms.get(currentRoomInList).clearBooking();
    }

    boolean CheckEachRoomIfBooked(int currentRoomInList){
        return this.rooms.get(currentRoomInList).checkIfBooked();
    }

    void bookTheFirstUnbookedRoom(int currentRoomInList){
        if(!this.rooms.get(currentRoomInList).checkIfBooked()){
            this.rooms.get(currentRoomInList).bookTheRoom();
        }
    }

}
