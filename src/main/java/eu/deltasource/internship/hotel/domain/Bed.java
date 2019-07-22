package eu.deltasource.internship.hotel.domain;

/**
 * SubClass to AbstractCommodity
 * HAS ADDITIONAL FIELD that contains how any people can sleep in the same bed
 */
public class Bed extends AbstractCommodity {
    private BedType bedType;

    /**
     * Bed constructor
     * enters empty number for commodity
     *
     * @param bedType enum BedType
     */
    public Bed(BedType bedType) {
        this.bedType = bedType;
        number = 0;
    }

    public int getNumberOfPersona() {
        return bedType.getSize();
    }

    public int getInventoryNumber() {
        return number;
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
        return (bed.number == this.number);
    }

    @Override
    public int hashCode() {
        return number;
    }

}
