package za.ac.cput.factory;
/*Booking.java
BookingFactory class
Author: SM Thwabuse(220246009)
Date: 18 May 2025*/
import za.ac.cput.Domain.Booking;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingFactory {

    //default date format

    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    //creating basic student booking

    public static Booking createBasicBooking( int bookingId, int studentId, String computerId) {
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStatus("Pending")
                .build();
    }

//creating booking with specific time slots

    public static Booking createBookingWithTimes(int bookingId, int studentId, String computerId,
                                                 String startTime, String endTime) {
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus("Confirmed")
                .build();
    }

    //creating booking for current time with default 3 hours duration

    public static Booking createNowBooking(int bookingId, int studentId, String computerId) {

        LocalDateTime now = LocalDateTime.now();
        String startTime = now.format(TIME_FORMATTER);
        String endTime = now.plusHours(3).format(TIME_FORMATTER);

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setStatus("Active")
                .build();
    }

    //creating booking with status

    public static Booking createBookingWithStatus(int bookingId, int studentId,
                                                  String computerId, String status) {
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(studentId)
                .setComputerId(computerId)
                .setStatus(status)
                .build();
    }

    //copy of existing booking

    public static Booking copyBooking(int bookingId, Booking initial ) {
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setStudentId(initial.getStudentId())
                .setComputerId(initial.getComputerId())
                .setStartTime(initial.getStartTime())
                .setEndTime(initial.getEndTime())
                .setStatus(initial.getStatus())
                .build();
    }
}
