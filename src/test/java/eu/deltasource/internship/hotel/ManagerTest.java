package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ManagerClass
 */
class ManagerTest {
    private static Manager manager = new Manager("Pesho Peshov");

    @Test
    public void assureStringToLocalDateWorks() {
        // given
        String stringDate = "2019-07-20";
        //when
        assertEquals(stringDate, manager.stringToLocalDate("2019-07-20").toString());
        //then
        System.out.println("LocalDate to String is working!");

    }

    @Test
    public void assureManagerNameIsCorrect() {
        // given
        String name = "Pesho Peshov";
        //when
        assertEquals(name, manager.getName());
        //then
        System.out.println("Manager's name is correct!");

    }

}