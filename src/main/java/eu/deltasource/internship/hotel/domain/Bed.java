package eu.deltasource.internship.hotel.domain;

import java.util.HashSet;

/**
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private BedType bedType;

    /**
     * Bed constructor. It checks if a bed with the same invNum already exists.
     *
     * @param inventoryNumber int number unique for any commodity
     * @param bedType         enum BedType
     * @param roomNumber      number of the room the bed belongs
     * @throws Exception if inventoryNumber is not unique
     */
    public Bed(int inventoryNumber, BedType bedType, int roomNumber) throws Exception {
        if (checkIfInventoryNumIsUnique(inventoryNumber)) {
            this.inventoryNumber = inventoryNumber;
            this.bedType = bedType;
            numberOfTheirRoom = roomNumber;
        } else {
            throw new Exception("Commodity already exists!");
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

    public void setRoom(int roomNumber) {
        numberOfTheirRoom = roomNumber;
    }

    public int getNumberOfPersona() {
        return bedType.getNumOfPersona();
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("main.java.eu.deltasource.internship.hotel.domain.Bed sheets are being replaced");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bed))
            return false;
        Bed bed = (Bed) obj;
        return (bed.inventoryNumber == this.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return numberOfTheirRoom;
    }

}
