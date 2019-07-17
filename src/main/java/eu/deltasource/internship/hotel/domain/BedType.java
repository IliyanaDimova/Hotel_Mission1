package eu.deltasource.internship.hotel.domain;

public enum BedType {
    SINGLE,
    DOUBLE,
    KINGSIZE;

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
}
