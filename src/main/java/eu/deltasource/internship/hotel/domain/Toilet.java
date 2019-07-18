package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    /**
     * Toilet constructor.  It checks if a toilet with the same invNum already exists.
     *
     * @param givenInventoryNumber int number unique for any commodity
     */
    public Toilet(int givenInventoryNumber) {
        this.inventoryNumber = givenInventoryNumber;
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
        return inventoryNumber;
    }

}
