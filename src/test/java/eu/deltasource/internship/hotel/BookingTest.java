package eu.deltasource.internship.hotel;

import eu.deltasource.internship.hotel.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private LocalDate from = LocalDate.of(2020, 1, 15);
    private LocalDate to = LocalDate.of(2020, 1, 16);

    @Test
    public void testGuestId() {
        //given
        Booking booking = new Booking("pesho-id", from, to);
        //when
        String id = "pesho-id";
        //then
        assertEquals(id, booking.getGuestId());
    }

    @Test
    public void testOverlappingDatesOverlap() {
        //given
        Booking booking = new Booking("pesho-id", from, to);
        //when
        LocalDate from1 = LocalDate.of(2020, 1, 16);
        LocalDate to1 = LocalDate.of(2020, 1, 17);
        //then
        assertTrue(booking.checkIfDatesOverlap(from1, to1));
    }

    @Test
    public void testNonOverlappingDatesDoNotOverlap() {
        //given
        Booking booking = new Booking("pesho-id", from, to);
        //when
        LocalDate from = LocalDate.of(2020, 2, 1);
        LocalDate to = LocalDate.of(2020, 2, 1);
        //then
        assertFalse(booking.checkIfDatesOverlap(from, to));
    }
}
