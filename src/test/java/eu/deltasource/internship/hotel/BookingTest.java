package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BookingTest {

    @Test
    public void testGuestId() {
        //given
        LocalDate from = LocalDate.parse("2020-01-01");
        LocalDate to = LocalDate.parse("2020-01-03");
        Booking booking = new Booking("pesho-id", from, to);
        //when
        String id = "pesho-id";
        //then
        assertEquals(id, booking.getGuestId());
    }

    @Test
    public void testAssertDatesOverlap() {
        //given
        LocalDate from = LocalDate.parse("2020-01-15");
        LocalDate to = LocalDate.parse("2020-01-16");
        Booking booking = new Booking("pesho-id", from, to);
        //when
        from = LocalDate.parse("2020-01-16");
        to = LocalDate.parse("2020-01-17");
        //then
        assertTrue(booking.checkIfDatesOverlap(from, to));
    }

    @Test
    public void testAssertDatesDoNotOverlap() {
        //given
        LocalDate from = LocalDate.parse("2020-01-11");
        LocalDate to = LocalDate.parse("2020-01-21");
        Booking booking = new Booking("pesho-id", from, to);
        //when
        from = LocalDate.parse("2020-01-22");
        to = LocalDate.parse("2020-01-23");
        //then
        assertFalse(booking.checkIfDatesOverlap(from, to));
    }
}
