import java.util.Scanner;
import java.util.ArrayList;

public class Hotel {
    String name;
    ArrayList<Room> rooms;

    Hotel() {
        Scanner name = new Scanner(System.in);
        System.out.println("Enter hotel's name: ");
        this.name = name.nextLine();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter hotel's number of rooms: ");
        int num_rooms = input.nextInt();
        this.rooms = new ArrayList<Room>();
        for (int i = 0; i<num_rooms; i++)
        {
            this.rooms.add(new Room());
        }
    }

    ArrayList<Room> number_of_available_rooms(Hotel this) {
        ArrayList<Room> avaliable_rooms = new ArrayList<Room>();
        for (int i = 0; i < this.rooms.size(); i++)
        {
            if(this.rooms.get(i).booked==false) avaliable_rooms.add(this.rooms.get(i));
            Object next = this.rooms.get(i);
        }
        return avaliable_rooms;
    }

}
