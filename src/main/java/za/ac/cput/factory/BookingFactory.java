package za.ac.cput.factory;

import za.ac.cput.Domain.Booking;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class BookingFactory {
    public static Booking createBooking(int studentId, String computerId,
                                        LocalDateTime startTime, LocalDateTime endTime,
                                        String status) {
        if (studentId <= 0 ||
                !Helper.isValidComputerId(computerId) ||
                startTime == null ||
                endTime == null ||
                !endTime.isAfter(startTime) ||
                !Helper.isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid booking details");
        }

        int bookingId = Helper.generateBookingId();

        return new Booking.Builder()
                .setBookingId(bookingId)
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
        if (bookingId <= 0 ||
                studentId <= 0 ||
                !Helper.isValidComputerId(computerId) ||
                startTime == null ||
                endTime == null ||
                !endTime.isAfter(startTime) ||
                !Helper.isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid booking details");
        }

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus(status)
                .build();
    }
}