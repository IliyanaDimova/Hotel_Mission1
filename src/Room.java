public class Room {

    private int number;
    private boolean booked;

    Room(int number) {
        this.number = number;
        this.booked = false;
    }

    void bookTheRoom() {
        this.booked = true;
    }

    void clearBooking() {
        this.booked = false;
    }

    boolean checkIfBooked() {
        if (!this.booked) {
            return false;
        }
        else return true;
    }

}
