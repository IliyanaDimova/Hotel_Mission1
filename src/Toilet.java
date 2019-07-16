/**
 * SubClass to AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    Toilet(int givenInventoryNumber, int roomNumber) {
        this.inventoryNumber = givenInventoryNumber;
        hashCode = roomNumber;
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
    public void setHashCode(int roomNumber){
        hashCode = roomNumber;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

}
