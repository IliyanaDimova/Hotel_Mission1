package eu.deltasource.internship.hotel.domain;

import java.util.HashSet;

/**
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    /**
     * Toilet constructor.  It checks if a toilet with the same invNum already exists.
     *
     * @param givenInventoryNumber int number unique for any commodity
     * @param roomNumber           number of the room the bed belongs
     * @throws Exception if inventoryNumber is not unique
     */
    public Toilet(int givenInventoryNumber, int roomNumber) throws MyException {
        if (checkIfInventoryNumIsUnique(inventoryNumber)) {
            this.inventoryNumber = givenInventoryNumber;
            numberOfTheirRoom = roomNumber;
        } else {
            throw new MyException("Commodity already exists!");
        }
    }

    /**
     * Checks if inventory number is already token by another commodity
     *
     * @param inventoryNumber
     * @return false if taken, true if inventory number is unique
     */
    public boolean checkIfInventoryNumIsUnique(int inventoryNumber) {
        HashSet<AbstractCommodity> allCommodities = new HashSet<>();
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
    public void setRoom(int roomNumber) {
        numberOfTheirRoom = roomNumber;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("The toilet is being cleaned");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Toilet))
            return false;
        Toilet toilet = (Toilet) obj;
        return (toilet.inventoryNumber == this.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return numberOfTheirRoom;
    }

}
