/**
 * SubClass to AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private int numberOfPersonas;

    Bed(int inventoryNumber, int numberOfPersonas) {
        this.inventoryNumber = inventoryNumber;
        this.numberOfPersonas = numberOfPersonas;
    }

    public int getNumberOfPersona() {
        return numberOfPersonas;
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("Bed sheets are being replaced");
    }

}
