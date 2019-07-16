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

    //underdeveloped code
    /*public boolean equals(AbstractCommodity obj) {
        if (inventoryNumber == obj.inventoryNumber) {
            return true;
        } else return false;
    }*/

    public abstract void setHashCode(int roomNumber);

    public abstract int hashCode();

}
