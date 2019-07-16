package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    public Shower(int inventoryNumber, int roomNumber) {
        this.inventoryNumber = inventoryNumber;
        hashCode = roomNumber;
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
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
