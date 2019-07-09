public class Manager {

    private String name;
    private Hotel hotel;

    Manager(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    Manager(String name) {
        this.name = name;
    }

    Manager(Hotel hotel) {
        this.hotel = hotel;
    }

    boolean checkForFreeRooms() {
        for (int i = 0; i < this.hotel.hotelNumberOfRooms(this.hotel); i++)
        {
            if(!this.hotel.CheckEachRoomIfBooked(i))
            {
                return true;
            }
        }
        return false;
    }

    void bookTheFirstAvailableRoom() {
        for (int i = 0; i < this.hotel.hotelNumberOfRooms(this.hotel); i++)
        {
            if(!this.hotel.CheckEachRoomIfBooked(i))
            {
                this.hotel.bookTheFirstUnbookedRoom(i);
            }
        }
    }

    void clearAllBookings(Hotel hotel){
        for (int i = 0; i < this.hotel.hotelNumberOfRooms(this.hotel); i++)
        {
            hotel.clearEachRoom(i);
        }
    }

}
