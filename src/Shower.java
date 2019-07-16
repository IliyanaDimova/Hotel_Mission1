/**
 * SubClass to AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    Shower(int inventoryNumber, int roomNumber) {
        this.inventoryNumber = inventoryNumber;
        hashCode = roomNumber;
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
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
