package eu.deltasource.internship.hotel.domain;

//todo constructor and implementation
public enum BedType {
    DOUBLE,
    SINGLE,
    KINGSIZE;
    /* SINGLE(1),
     DOUBLE(2),
     KINGSIZE(3)
     ;*/
    // private int size;

    //todo won't need this then
    public int getNumOfPersona() {
        switch (this) {
            case SINGLE:
                return 1;
            case DOUBLE:
                return 2;
            case KINGSIZE:
                return 2;
        }
        return 0;
    }

    /*
    BedType(int size) {
        this.size = size;
    }
    */
}
