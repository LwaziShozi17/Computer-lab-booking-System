package za.ac.cput.factory;
/*
 BookingFactory class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import za.ac.cput.Domain.Booking;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.Objects;

public final class BookingFactory {
    private BookingFactory() {}

    public static Booking createBooking(int studentId, String computerId,
                                        LocalDateTime startTime, LocalDateTime endTime,
                                        String status) {
        validateBooking(studentId, computerId, startTime, endTime, status);

        return new Booking.Builder()
                .setBookingId(Helper.generateBookingId())
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus(status)
                .build();
    }

    public static Booking createBookingWithId(int bookingId, int studentId,
                                              String computerId, LocalDateTime startTime,
                                              LocalDateTime endTime, String status) {
        if (!Helper.isValidBookingId(bookingId)) {
            throw new IllegalArgumentException("Invalid booking ID");
        }
        validateBooking(studentId, computerId, startTime, endTime, status);

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus(status)
                .build();
    }

    private static void validateBooking(int studentId, String computerId,
                                        LocalDateTime startTime, LocalDateTime endTime,
                                        String status) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be positive");
        }
        if (!Helper.isValidComputerId(computerId)) {
            throw new IllegalArgumentException("Invalid computer ID format");
        }
        if (Objects.isNull(startTime) || Objects.isNull(endTime) || !endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("Invalid time range");
        }
        if (!Helper.isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid booking status");
        }
    }
}
