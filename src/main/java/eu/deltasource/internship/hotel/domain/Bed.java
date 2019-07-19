package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private BedType bedType;

    /**
     * Bed constructor
     *
     * @param inventoryNumber int number unique for any commodity
     * @param bedType         enum BedType
     */
    public Bed(int inventoryNumber, BedType bedType) {
        this.inventoryNumber = inventoryNumber;
        this.bedType = bedType;
    }

    public int getNumberOfPersona() {
        return bedType.getSize();
    }

    /**
     * {@inheritDoc}
     * {@linkAbstractCommodity}
     */
    @Override
    public void prepare() {
        System.out.println("Bed sheets are being replaced");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bed))
            return false;
        Bed bed = (Bed) obj;
        return (bed.inventoryNumber == this.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return inventoryNumber;
    }

}
