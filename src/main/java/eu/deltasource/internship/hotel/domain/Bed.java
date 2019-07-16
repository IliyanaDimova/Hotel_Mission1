package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to main.java.eu.deltasource.internship.hotel.domain.AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private int numberOfPersona;

    public Bed(int inventoryNumber, int numberOfPersona, int roomNumber) {
        this.inventoryNumber = inventoryNumber;
        this.numberOfPersona = numberOfPersona;
        hashCode = roomNumber;
    }

    public int getNumberOfPersona() {
        return numberOfPersona;
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
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
