package eu.deltasource.internship.hotel.domain;

public class UniqueCommodityNumber {
    private static int roomNum;

    /**
     * UniqueCommodityNumber constructor
     */
    public UniqueCommodityNumber(){
        roomNum = 0;
    }

    /**
     * Increments roomNum with 1
     * @return roomNum
     */
    public int getCommodityNumAndIncrement(){
        roomNum++;
        return roomNum;
    }

}
