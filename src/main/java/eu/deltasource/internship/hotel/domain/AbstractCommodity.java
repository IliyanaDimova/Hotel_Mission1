package eu.deltasource.internship.hotel.domain;

/**
 * AbstractCommodity is SuperClass to: Shower, Bed and Toilet (Commodities that are a Set in every room)
 * every commodity has unique inventory number generated through the static field in Hotel
 */
public abstract class AbstractCommodity {
    protected int number;

    public void setInventoryNumber(int number) {
        this.number = number;
    }

    public int getInventoryNumber() {
        return number;
    }

    /**
     * Override method in subclasses - prints a message that the commodity is being prepared
     */
    public abstract void prepare();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}
