public class Toilet extends AbstractCommodity {

    void Toilet(int givenInventaryNumber){
        this.inventaryNumber = givenInventaryNumber;
    }

    @Override
    int getNumberOfPersonasPerBed(){
        return 0;
    }

    @Override
    void prepare() {
        System.out.println("The toilet is being cleaned");
    }
}
