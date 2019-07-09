public class Main {

    public static void main(String args[]) {
        Manager manager1 = new Manager();
        System.out.println(manager1.name+ " " + manager1.resp_hotel.name + " " + manager1.resp_hotel.rooms.get(1).number);
        if(manager1.check_for_free_rooms()==false)
        {
            manager1.check_the_first_available_room();
        }
        manager1.clear_all_bookings();
    }
}
