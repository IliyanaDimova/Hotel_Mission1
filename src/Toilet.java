public class Toilet extends AbstractCommodity {

    Toilet(int givenInventoryNumber) {
        this.inventoryNumber = givenInventoryNumber;
    }

    @Override
    public void prepare() {
        System.out.println("The toilet is being cleaned");
    }

}
