package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    public Toilet(int givenInventoryNumber, int roomNumber) {
        this.inventoryNumber = givenInventoryNumber;
        hashCode = roomNumber;
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
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
