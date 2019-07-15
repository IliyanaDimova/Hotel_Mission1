public class Bed extends AbstractCommodity {
    private int numberOfPersonas;

    Bed(int givenInventoryNumber, int givenNumberOfPersonas) {
        this.inventoryNumber = givenInventoryNumber;
        this.numberOfPersonas = givenNumberOfPersonas;
    }

    public void Bed(int givenInventaryNumber) {
        this.inventoryNumber = givenInventaryNumber;
    }

    public int getNumberOfPersonaPerBed() {
        return this.numberOfPersonas;
    }

    public void setNumberOfPersonas(int givenNumberOfPersonas) {
        this.numberOfPersonas = givenNumberOfPersonas;
    }

    @Override
    public void prepare() {
        System.out.println("Bed sheets are being replaced");
    }

}
