/**
 * SubClass to AbstractCommodity
 */
public class Shower extends AbstractCommodity {

    Shower(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("The shower is being cleaned");
    }
}
