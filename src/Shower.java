public class Shower extends AbstractCommodity {

    Shower(int givenInventoryNumber) {
        this.inventoryNumber = givenInventoryNumber;
    }

    @Override
    public void prepare() {
        System.out.println("The shower is being cleaned");
    }
}
