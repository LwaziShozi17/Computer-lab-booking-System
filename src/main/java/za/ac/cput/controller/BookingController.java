package za.ac.cput.controller;

/*
 BookingController class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Booking;
import za.ac.cput.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody Booking booking) {
        try {
            if (!bookingService.isComputerAvailable(booking.getComputerId(), booking.getStartTime(), booking.getEndTime())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Computer " + booking.getComputerId() + " is already booked for this time slot");
            }

            Booking created = bookingService.save(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{Booking}")
    public ResponseEntity<?> getBooking(@PathVariable int BookingId) {
        try {
            Booking booking = bookingService.read(BookingId);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{Booking}")
    public ResponseEntity<?> updateBooking(@PathVariable int BookingId, @Valid @RequestBody Booking booking) {
        try {
            if (BookingId != booking.getBookingId()) {
                return ResponseEntity.badRequest().body("ID in path and body must match");
            }

            Booking updated = bookingService.update(booking);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{Booking}")
    public ResponseEntity<?> deleteBooking(@PathVariable int BookingId) {
        try {
            bookingService.delete(BookingId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(required = false) String computerId,
            @RequestParam(required = false) String status) {

        List<Booking> bookings = bookingService.getAll().values().stream()
                .filter(b -> computerId == null || b.getComputerId().equals(computerId))
                .filter(b -> status == null || b.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/availability")
    public ResponseEntity<?> checkAvailability(
            @RequestParam String computerId,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime) {

        boolean isAvailable = bookingService.isComputerAvailable(computerId, startTime, endTime);
        return ResponseEntity.ok(Map.of(
                "computerId", computerId,
                "startTime", startTime,
                "endTime", endTime,
                "available", isAvailable
        ));
    }
}



