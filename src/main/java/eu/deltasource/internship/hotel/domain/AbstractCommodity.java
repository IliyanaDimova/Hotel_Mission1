package eu.deltasource.internship.hotel.domain;

/**
 * SuperClass to: main.java.eu.deltasource.internship.hotel.domain.Toilet Class, main.java.eu.deltasource.internship.hotel.domain.Shower Class, main.java.eu.deltasource.internship.hotel.domain.Bed Class (Commodities that are a Set field in a room)
 * has inventory number by which commodities are recognized as hotel's property
 */
public abstract class AbstractCommodity {
    protected int inventoryNumber;
    protected int numberOfTheirRoom;

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
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Sets the number of the room that the commodity belongs to
     *
     * @param roomNumber the room number becomes the hashcode of the commodity set of the room
     */
    public abstract void setRoom(int roomNumber);

    /**
     * Gets the hashcode of the commodity
     *
     * @return hashCode
     */
    @Override
    public abstract int hashCode();

}
