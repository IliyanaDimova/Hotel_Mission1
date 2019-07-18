package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    /**
     * Shower constructor.  It checks if a shower with the same invNum already exists.
     *
     * @param inventoryNumber int number unique for any commodity
     */
    public Shower(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
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
    public int hashCode() {
        return inventoryNumber;
    }

}
