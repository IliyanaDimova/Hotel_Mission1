package eu.deltasource.internship.hotel.domain;

import java.util.HashSet;

/** //todo clean up
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    /**
     * Shower constructor.  It checks if a shower with the same invNum already exists.
     *
     * @param inventoryNumber int number unique for any commodity
     * @param roomNumber      number of the room the bed belongs
     * @throws Exception if inventoryNumber is not unique //todo exception type
     */
    public Shower(int inventoryNumber, int roomNumber) throws NoRoomsAvailableException {
        if (checkIfInventoryNumIsUnique(inventoryNumber)) {
            this.inventoryNumber = inventoryNumber;
            numberOfTheirRoom = roomNumber;
        } else {
            throw new NoRoomsAvailableException("Commodity already exists!");
        }
    }

    /** //todo if inventory numbers are uniquely generated, this check will not be needed
     * Checks if inventory number is already token by another commodity
     *
     * @param inventoryNumber
     * @return false if taken, true if inventory number is unique
     */
    public boolean checkIfInventoryNumIsUnique(int inventoryNumber) {
        HashSet<AbstractCommodity> allCommodities = new HashSet<>(); //todo reference should be Set
        for (AbstractCommodity commodity : allCommodities) {
            if (inventoryNumber == commodity.hashCode()) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("The shower is being cleaned");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shower))
            return false;
        Shower shower = (Shower) obj;
        return (shower.inventoryNumber == this.inventoryNumber);
    }

    @Override
    public void setRoom(int roomNumber) {
        numberOfTheirRoom = roomNumber;
    }

    @Override
    public int hashCode() {
        return numberOfTheirRoom;
    }

}
