import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    Hotel(String name, ArrayList<Room> rooms)
    {
        this.name = name;
        this.rooms = rooms;
    }

    String getName()
    {
        return this.name;
    }

    ArrayList<Room> getRooms()
    {
        return this.rooms;
    }

    int hotelNumberOfRooms()
    {
        return this.rooms.size();
    }

    ArrayList<Room> findAllAvailableRoomsForIntervalAndSize(Date from, Date to, int numberOfPeople)
    {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.rooms.get(i).findIfAvailableForIntervalAndSize(from, to, numberOfPeople)){
                availableRooms.add(this.rooms.get(i));
            }
        }
        return availableRooms;
    }

    Room findPerfectFitRoomOrReturnNull(Date from, Date to, int personas)
    {
        int thereIsPerfectRoom = 0;

        ArrayList<Room> availableRooms = new ArrayList<>();
        availableRooms = findAllAvailableRoomsForIntervalAndSize(from, to, personas);

        if (availableRooms.size() == 0) {
            System.out.println("There are no acceptable rooms in this hotel!");
            return null;
        }

        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i).IsAPerfectMatchRoom(personas)) {
                thereIsPerfectRoom++;
            }
            if(thereIsPerfectRoom>0) {
                return availableRooms.get(i);
            }
        }

        for (int i = 0; i < availableRooms.size(); i++) {
            int numberOfTwoPersonaBeds = availableRooms.get(i).getNumberOfTwoPersonaBeds();
            int numberOfOnePersonaBeds = availableRooms.get(i).getNumberOfOnePersonaBeds();
            System.out.println("Room #" + availableRooms.get(i).getNumber() + " has ");
            System.out.println(numberOfTwoPersonaBeds + "two personas beds and" + numberOfOnePersonaBeds + "one persona beds");
        }
        System.out.println("Please book the room with the acceptable number of beds by choosing it's commodities!");
        return null;
    }

}
