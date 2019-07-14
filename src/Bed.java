public class Bed extends AbstractCommodity {
    int numberOfPersonas;

    void Bed(int givenInventaryNumber, int givenNumberOfPersonas){
        this.inventaryNumber = givenInventaryNumber;
        this.numberOfPersonas = givenNumberOfPersonas;
    }

    void Bed(int givenInventaryNumber){
        this.inventaryNumber = givenInventaryNumber;
    }

    @Override
    int getNumberOfPersonasPerBed(){
        return this.numberOfPersonas;
    }

    void setNumberOfPersonas(int givenNumberOfPersonas){
        this.numberOfPersonas = givenNumberOfPersonas;
    }

    @Override
    void prepare() {
        System.out.println("Bed sheets are being replaced");
    }
}
