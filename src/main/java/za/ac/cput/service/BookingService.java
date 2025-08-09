package za.ac.cput.service;

/*
 BookingService class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Repository.BookingRepository;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class BookingService {
    private BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking save(Booking booking) {
        if (booking == null || booking.getBookingId() <= 0) {
            throw new IllegalArgumentException("Invalid booking data");
        }

        Booking existing = repository.read(booking.getBookingId());
        if (existing != null) {
            throw new RuntimeException("Booking with ID " + booking.getBookingId() + " already exists");
        }
        return repository.create(booking);
    }

    public Booking read(int bookingId) {
        Booking booking = repository.read(bookingId);
        if (booking == null) {
            throw new RuntimeException("Booking with ID " + bookingId + " not found");
        }
        return booking;
    }

    public Booking update(Booking booking) {
        if (repository.read(booking.getBookingId()) == null) {
            throw new RuntimeException("Booking not found for update");
        }
        return repository.update(booking);
    }

    public boolean delete(int bookingId) {
        if (repository.read(bookingId) == null) {
            throw new RuntimeException("Booking not found for deletion");
        }
        return repository.delete(bookingId);
    }

    public Map<Integer, Booking> getAll() {
        return repository.getAll();
    }

    public boolean isComputerAvailable(String computerId, LocalDateTime startTime, LocalDateTime endTime) {
        return repository.getAll().values().stream()
                .noneMatch(b -> b.getComputerId().equals(computerId) &&
                        !(endTime.isBefore(b.getStartTime()) || startTime.isAfter(b.getEndTime())));
    }
}



