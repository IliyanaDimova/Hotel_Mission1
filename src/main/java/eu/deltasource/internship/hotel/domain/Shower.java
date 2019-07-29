package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    /**
     * Shower constructor
     *
     * @param number inventory number
     */
    public Shower(int number) {
        this.number = number;
    }

    public int getInventoryNumber() {
        return number;
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
        return (shower.number == this.number);
    }

    @Override
    public int hashCode() {
        return number;
    }

}
