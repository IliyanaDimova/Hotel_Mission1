public class Shower extends AbstractCommodity {

    void Shower(int givenInventaryNumber){
        this.inventaryNumber = givenInventaryNumber;
    }

    @Override
    int getNumberOfPersonasPerBed(){
        return 0;
    }

    @Override
    void prepare() {
        System.out.println("The shower is being cleaned");
    }
}
