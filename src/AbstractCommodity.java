public abstract class AbstractCommodity {
    protected int inventoryNumber;

    //Prints message that commodity is being prepared
    public abstract void prepare();

    public boolean equals(AbstractCommodity obj) {
        if (inventoryNumber == obj.inventoryNumber) {
            return true;
        } else return false;
    }

    /*public int hashCode() {
         return rank.hashCode();
     }*/

}
