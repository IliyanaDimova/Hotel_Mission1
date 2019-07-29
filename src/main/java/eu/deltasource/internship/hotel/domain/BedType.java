package eu.deltasource.internship.hotel.domain;

/**
 * Enum that indicates the type of the bed and how many people can sleep on it
 * Every Bed has a BedType
 */
public enum BedType {
    SINGLE(1),
    DOUBLE(2),
    KINGSIZE(2);

    private final int size;

    /**
     * Constructor
     *
     * @param size the persona of the bed
     */
    BedType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
