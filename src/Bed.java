/**
 * SubClass to AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private int numberOfPersona;

    Bed(int inventoryNumber, int numberOfPersona, int roomNumber) {
        this.inventoryNumber = inventoryNumber;
        this.numberOfPersona = numberOfPersona;
        hashCode = roomNumber;
    }

    public int getNumberOfPersona() {
        return numberOfPersona;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("Bed sheets are being replaced");
    }

    @Override
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
