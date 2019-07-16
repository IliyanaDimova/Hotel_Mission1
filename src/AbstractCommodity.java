/**
 * SuperClass to: Toilet Class, Shower Class, Bed Class (Commodities that are a Set field in a room)
 * has inventory number by which commodities are recognized as hotel's property
 */
public abstract class AbstractCommodity {
    protected int inventoryNumber;
    protected int hashCode;

    /**
     * Override method in subclasses - prints a message that the commodity is being prepared
     */
    public abstract void prepare();

    /**
     * Same for every commodity
     *
     * @param obj The comodity
     * @return true if equal
     */
    public boolean equals(AbstractCommodity obj) {
        if (inventoryNumber == obj.inventoryNumber && obj!=null) {
            return true;
        } else return false;
    }

    /**
     * Sets HashCode
     *
     * @param roomNumber the room number becomes the hashcode of the commodity set of the room
     */
    public abstract void setHashCode(int roomNumber);

    /**
     * Gets the hashcode of the commodity
     *
     * @return hashCode
     */
    public abstract int hashCode();

}
