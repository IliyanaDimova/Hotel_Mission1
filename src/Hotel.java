import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public int hotelNumberOfRooms() {
        return this.rooms.size();
    }

    /**
     * @param from
     * @param to
     * @param numberOfPeople
     * @return
     */
    public ArrayList<Room> findAllAvailableRoomsForIntervalAndSize(LocalDate from, LocalDate to, int numberOfPeople) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.rooms.get(i).findIfAvailableForIntervalAndSize(from, to, numberOfPeople)) {
                availableRooms.add(this.rooms.get(i));
            }
        }
        return availableRooms;
    }

    public Room findPerfectFitRoomOrReturnNull(LocalDate from, LocalDate to, int personas) {
        int thereIsPerfectRoom = 0;

        ArrayList<Room> availableRooms = new ArrayList<>();
        System.out.println("First available room is # ");
        availableRooms = this.findAllAvailableRoomsForIntervalAndSize(from, to, personas);

        if (availableRooms.size() == 0) {
            System.out.println("There are no acceptable rooms in this hotel!");
            return null;
        }

        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i).IsAPerfectMatchRoom(personas)) {
                thereIsPerfectRoom++;
            }
            if (thereIsPerfectRoom > 0) {
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
