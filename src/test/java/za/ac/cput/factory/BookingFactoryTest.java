package za.ac.cput.factory;
/*Booking.java
BookingFactoryTest class
Author: SM Thwabuse(220246009)
Date: 18 May 2025*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Booking;
import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {
    // Creating objects for testing
    private static Booking b1 = BookingFactory.createBasicBooking(1001, 220247884, "PC-101");
    private static Booking b2 = BookingFactory.createBookingWithTimes(1002, 230548574, "PC-102",
            "2025-05-27 14:00", "2025-05-23 17:00");
    private static Booking b3 = BookingFactory.createBookingWithStatus(1003, 213484739, "PC-103", "Cancelled");
    private static Booking b4 = BookingFactory.copyBooking(1004, b1);

    @Test
    @Order(1)
    public void testCreateBasicBooking() {
        assertNotNull(b1);
        assertEquals("Pending", b1.getStatus());
        System.out.println("Basic Booking: " + b1);
    }

    @Test
    @Order(2)
    public void testCreateBookingWithTimes() {
        assertNotNull(b2);
        assertEquals("Confirmed", b2.getStatus());
        assertNotNull(b2.getStartTime());
        assertNotNull(b2.getEndTime());
        System.out.println("Timed Booking: " + b2);
    }

    @Test
    @Order(3)
    public void testCreateBookingWithStatus() {
        assertNotNull(b3);
        assertEquals("Cancelled", b3.getStatus());
        System.out.println("Status Booking: " + b3);
    }

    @Test
    @Order(4)
    public void testCopyBooking() {
        assertNotNull(b4);
        assertEquals(b1.getStudentId(), b4.getStudentId());
        assertEquals(b1.getComputerId(), b4.getComputerId());
        assertNotEquals(b1.getBookingId(), b4.getBookingId());
        System.out.println("Initial: " + b1);
        System.out.println("Copy: " + b4);
    }

    @Test
    @Disabled
    @Order(5)
    public void testCreateNowBooking() {

    }

    @Test
    @Disabled
    @Order(6)
    public void testInvalidBooking() {
    }

}
