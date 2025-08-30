package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/http/cputlibrary.com")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Method to create booking in the database
    @PostMapping("/Book")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking createBooking = bookingService.create(booking);
            return ResponseEntity.ok(createBooking);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error : Booking Already" + e.getMessage() );
        }
    }

    // Method to search and find booking by studentId in database
    @GetMapping("/LoadBookingByStudentId/{studentId}")
    public ResponseEntity<?> findBookingByStudentId(@PathVariable Long studentId) {
        try {
            Booking booking = bookingService.read(studentId);
            return ResponseEntity.ok(Map.of(
                    "bookingId", booking.getBookingId(),
                    "studentId", booking.getStudentId(),
                    "computerId", booking.getComputerId(),
                    "faculty", booking.getFaculty(),
                    "course", booking.getCourse(),
                    "startTime", booking.getStartTime(),
                    "endTime", booking.getEndTime(),
                    "software", booking.getSoftware()
            ));
        } catch (RuntimeException e) {
            System.out.println("Booking not found for studentId: " + studentId);
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/LoadBookingByBookingId/{bookingId}")
    public ResponseEntity<?> findBookingByBookingId(@PathVariable Long bookingId) {
        try {
            Booking booking = bookingService.searchByBookingId(bookingId);
            return ResponseEntity.ok(Map.of(
                    "bookingId", booking.getBookingId(),
                    "studentId", booking.getStudentId(),
                    "computerId", booking.getComputerId(),
                    "faculty", booking.getFaculty(),
                    "course", booking.getCourse(),
                    "startTime", booking.getStartTime(),
                    "endTime", booking.getEndTime(),
                    "software", booking.getSoftware()
            ));
        } catch (RuntimeException e) {
            System.out.println("Booking not found for bookingId: " + bookingId);
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Method to delete booking by studentId in the database
    // Cancel booking by Booking ID
    @DeleteMapping("/CancelBookingByBookingId/{bookingId}")
    public ResponseEntity<?> deleteBookingByBookingId(@PathVariable Long bookingId) {
        try {
            bookingService.deleteByBookingId(bookingId);
            return ResponseEntity.ok(Map.of("message", "Booking deleted successfully", "bookingId", bookingId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/CancelBookingByStudentId/{studentId}")
    public ResponseEntity<?> deleteBookingByStudentId(@PathVariable Long studentId) {
        try {
            bookingService.deleteByStudentId(studentId);
            return ResponseEntity.ok(Map.of("message", "Booking(s) deleted successfully", "studentId", studentId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}
