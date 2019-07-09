import java.util.Scanner;

public class Manager {

    String name;
    Hotel resp_hotel;

    Manager() {
        Scanner name = new Scanner(System.in);
        System.out.println("Enter your (manager's) name: ");
        this.name = name.nextLine();
        Hotel hotel = new Hotel();
        this.resp_hotel = hotel;
    }

    boolean check_for_free_rooms() {
        for (int i = 0; i < this.resp_hotel.rooms.size(); i++)
        {
            if (!this.resp_hotel.rooms.get(i).check_if_booked(this.resp_hotel.rooms.get(i))) //FALSE=>НЕ Е ЗАЕТА
            {
                return false;
            }
        }
        return true;
    }

    void check_the_first_available_room() {
        for (int i = 0; i < this.resp_hotel.rooms.size(); i++)
        {
            if (!this.resp_hotel.rooms.get(i).check_if_booked(this.resp_hotel.rooms.get(i)))
            {
                this.resp_hotel.rooms.get(i).book_the_room(this.resp_hotel.rooms.get(i));
            }
        }
    }

    void clear_all_bookings(){
        for (int i = 0; i < this.resp_hotel.rooms.size(); i++)
        {
            this.resp_hotel.rooms.get(i).clear_booking(this.resp_hotel.rooms.get(i));
        }
    }

}
