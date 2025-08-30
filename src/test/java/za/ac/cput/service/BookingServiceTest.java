/*
BookingServiceTest.java
Booking ServiceTest class
Author: SE Sibiya (230975623)
Date: 20 August 2025
*/

package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BookingServiceTest {
    @Autowired
    private IBooking bookingService;

    private Booking booking = BookingFactory.createBooking(
            212966623L,
            "Applied Sciences",
            "Computer Science",
            "Intel-i3",
            "2025-08-21 14:00",
            "2025-08-21 15:00",
            "Pycharm"
    );

    @Test
    @Order(1)
    void create() {
        Booking savedBooking = bookingService.create(booking);
        assertNotNull(savedBooking);
        System.out.println("Created Booking: \n");
    }

    @Test
    @Order(2)
    void read() {
            Booking readBooking = bookingService.read(booking.getStudentId());
            assertNotNull(readBooking);
            System.out.println("Saved booking ID: " + readBooking);
    }

    @Test
    @Order(3)
    void update() {
        // First read the existing booking
        Booking existingBooking = bookingService.read(booking.getStudentId());

        // Create updated version with SAME bookingId
        Booking updatedBooking = new Booking.Builder().copy(existingBooking)
                .setCourse("Multimedia Fundamentals")
                .setComputerId("HP-10")
                .build();
        Booking updateBooking = bookingService.update(updatedBooking);
        assertNotNull(updateBooking);
        System.out.println("Updated Booking: " + updateBooking);
    }

    @Test
    @Order(4)
    void delete() {
        Booking deleteBooking = bookingService.delete(booking.getStudentId());
        assertNotNull(deleteBooking);
        System.out.println("Deleted booking ID: " + deleteBooking);
    }

    @Test
    @Order(5)
    void findAllBookings() {
        for (Booking book : bookingService.findAllBookings()) {
            assertNotNull(book);
            System.out.println("Found Booking: " + book);
        }
    }

    @Test
    @Order(6)
    void findByBookingId() {
        Long bookingId = 90012L;

        Booking bookingById = bookingService.searchByBookingId(bookingId);
        assertNotNull(bookingById);
        System.out.println("Found Booking by ID: " + bookingById);
    }

}