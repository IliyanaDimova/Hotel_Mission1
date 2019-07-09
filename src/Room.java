import java.util.Scanner;

public class Room {

    int number;
    boolean booked;

    Room() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room's number: ");
        this.number = input.nextInt();
        this.booked = false;
    }

    void book_the_room(Room room) {
        room.booked = true;
    }

    void clear_booking(Room room) {
        room.booked = false;
    }

    boolean check_if_booked(Room room) {
        if (room.booked == false) return false;
        else return true;
    }

}
