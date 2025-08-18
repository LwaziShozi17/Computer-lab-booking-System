package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void createBooking() {
        Booking booking = BookingFactory.createBooking(
                1, 1001, "COMP001", "09:00", "10:00", "ACTIVE"
        );
        
        assertNotNull(booking);
        assertEquals(1, booking.getBookingId());
        assertEquals(1001, booking.getStudentId());
        assertEquals("COMP001", booking.getComputerId());
        assertEquals("09:00", booking.getStartTime());
        assertEquals("10:00", booking.getEndTime());
        assertEquals("ACTIVE", booking.getStatus());
    }

    @Test
    void createBookingWithNullValues() {
        Booking booking = BookingFactory.createBooking(
                0, 0, null, null, null, null
        );
        
        assertNull(booking);
    }
}
