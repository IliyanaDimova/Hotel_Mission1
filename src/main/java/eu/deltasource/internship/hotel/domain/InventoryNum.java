package eu.deltasource.internship.hotel.domain;

/**
 * This is the inventory number of every commodity
 * It has roomNum for the number oth the room the commodity belongs to
 * and commodityNum for the actual number of the commodity in the room
 */
public class InventoryNum {
    private int roomNum;
    private int commodityNum;

    /**
     * InventoryNum constructor - initializes commodity without a room
     */
    public InventoryNum() {
        this.roomNum = 0;
        this.commodityNum = 0;
    }

    /**
     * InventoryNum constructor - initializes commodity with room
     *
     * @param roomNum      the room which the commodity belongs to's number
     * @param commodityNum the actual number of the commodity in the room
     */
    public InventoryNum(int roomNum, int commodityNum) {
        this.roomNum = roomNum;
        this.commodityNum = commodityNum;
    }

    public int getCommodityNum() {
        return commodityNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InventoryNum))
            return false;
        InventoryNum invNum = (InventoryNum) obj;
        return ((invNum.roomNum == this.roomNum) && (invNum.commodityNum == this.commodityNum));
    }

    /*@Override
    public int hashCode() {
        return roomNum;
    }*/
}
