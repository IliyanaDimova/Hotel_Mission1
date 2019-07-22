package eu.deltasource.internship.hotel.domain;

/**
 * SuperClass to: Shower Class, Bed Class and Toilet Class (Commodities that are a Set field in a room)
 * every commodity has unique inventory number generated through the static field in Hotel_Class
 */
public abstract class AbstractCommodity {
    protected int number;

    public void setInventoryNumber(int commodityNum){
        number = commodityNum;
    }

    public int getInventoryNumber(){
        return number;
    }

    /**
     * Override method in subclasses - prints a message that the commodity is being prepared
     */
    public abstract void prepare();

    /**
     * Same for every commodity
     *
     * @param obj The commodity
     * @return true if equal
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Gets the hashcode of the commodity
     *
     * @return hashCode
     */
    @Override
    public abstract int hashCode();
}
