public abstract class AbstractCommodity {
    protected int inventaryNumber;

    //returns 0 if this is Toilet or Shower, numberOfPersonas if Bed
    abstract int getNumberOfPersonasPerBed();

    //Prints message that commodity is being prepared
     abstract void prepare();

}
