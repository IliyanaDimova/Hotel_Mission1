package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommodityTest {

    @Test
    public void testCommodityInventoryNumbers() {
        //given
        UniqueCommodityNumber rememberLastCommodityNum = new UniqueCommodityNumber();
        //when
        Bed bed = new Bed(rememberLastCommodityNum.getCommodityNumAndIncrement(), BedType.SINGLE);
        Toilet toilet = new Toilet(rememberLastCommodityNum.getCommodityNumAndIncrement());
        Shower shower = new Shower(rememberLastCommodityNum.getCommodityNumAndIncrement());
        //then
        assertEquals(1, bed.getInventoryNumber());
        assertEquals(2, toilet.getInventoryNumber());
        assertEquals(3, shower.getInventoryNumber());
    }
}
