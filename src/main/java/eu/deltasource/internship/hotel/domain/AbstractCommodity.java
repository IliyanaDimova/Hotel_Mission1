package eu.deltasource.internship.hotel.domain;

/**
 * SuperClass to: Shower Class, Bed Class and Toilet Class (Commodities that are a Set field in a room)
 */
public abstract class AbstractCommodity {
    protected InventoryNum number;

    public void setInventoryNumber(int roomNum, int commodityNum){
        number = new InventoryNum(roomNum, commodityNum);
    }

    public InventoryNum getInventoryNumber(){
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
