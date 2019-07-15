/**
 * SubClass to AbstractCommodity
 */
public class Toilet extends AbstractCommodity {

    Toilet(int givenInventoryNumber) {
        this.inventoryNumber = givenInventoryNumber;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("The toilet is being cleaned");
    }

}
