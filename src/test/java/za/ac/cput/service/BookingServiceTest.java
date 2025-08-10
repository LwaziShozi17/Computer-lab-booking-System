package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Booking;
import za.ac.cput.factory.BookingFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;

    private Booking booking = BookingFactory.createBooking(
            123456,
            "COM-101",
            LocalDateTime.now().plusHours(1),
            LocalDateTime.now().plusHours(2),
            "BOOKED");

    @Test
    @Order(1)
    void create() {
        Booking savedBooking = bookingService.save(booking);
        assertNotNull(savedBooking);
        System.out.println("Saved Booking: " + savedBooking);
    }

    @Test
    @Order(2)
    void read() {
        Booking readBooking = bookingService.read(booking.getBookingId());
        assertNotNull(readBooking);
        System.out.println("Read Booking: " + readBooking);
    }

    @Test
    @Order(3)
    void update() {
        Booking updatedBooking = new Booking.Builder().copy(booking)
                .setStatus("CONFIRMED")
                .build();
        Booking result = bookingService.update(updatedBooking);
        assertNotNull(result);
        System.out.println("Updated Booking: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = bookingService.delete(booking.getBookingId());
        assertTrue(deleted);
        System.out.println("Deleted Booking ID: " + booking.getBookingId());
    }

    @Test
    @Order(5)
    void getAll() {
        for (Booking booking : bookingService.getAll().values()) {
            assertNotNull(booking);
            System.out.println("Found Booking: " + booking);
        }
    }
}