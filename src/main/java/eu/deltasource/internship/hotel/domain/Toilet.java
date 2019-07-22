package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    /**
     * Toilet constructor
     * sets empty number for commodity
     */
    public Toilet() {
        number = 0;
    }

    public int getInventoryNumber(){
        return number;
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
        return (toilet.number == this.number);
    }

    @Override
    public int hashCode() {
        return number;
    }

}
