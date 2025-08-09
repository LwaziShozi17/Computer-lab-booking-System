package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Booking;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

@Test
    @Order(1)
void testCreateBooking() {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start.plusHours(2);

    Booking booking = BookingFactory.createBooking(
            220246,
            "COM-101",
            start,
            end,
            "BOOKED"
    );
    assertNotNull(booking);
    assertTrue(booking.getStudentId() >= 1000);
    assertTrue(booking.getBookingId() >= 1000 && booking.getBookingId() <= 9999);
    System.out.println("Created Booking: " + booking);

}

@Test
@Order(2)
void testCreateBookingWithId() {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start.plusHours(1);

    Booking booking = BookingFactory.createBookingWithId(
            2025,
            654321,
            "COM-202",
            start,
            end,
            "BOOKED"
    );
    assertEquals(2025, booking.getBookingId());
    System.out.println("Created booking with ID: " + booking);

}

@Test
@Order(3)
void testInvalidComputerId() {
    LocalDateTime now = LocalDateTime.now();
    assertThrows(IllegalArgumentException.class, () ->
            BookingFactory.createBooking(
                    123456,
                    "INVALID",
                    now,
                    now.plusHours(2),
                    "BOOKED"
            ));
}

@Test
@Order(4)
void testInvalidTimeRange() {
    LocalDateTime now = LocalDateTime.now();
    assertThrows(IllegalArgumentException.class, () ->
            BookingFactory.createBooking(
                    123456,
                    "COM-101",
                    now,
                    now.minusHours(1),
                    "BOOKED"
            ));
}

}
