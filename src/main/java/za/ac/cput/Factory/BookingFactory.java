package za.ac.cput.Factory;

import za.ac.cput.Domain.Booking;
import za.ac.cput.util.Helper;

public class BookingFactory {
    public static Booking createBooking(int bookingId, int studentId, String computerId, 
                                      String startTime, String endTime, String status) {
        if (Helper.isNullOrEmpty(String.valueOf(bookingId)) || 
            Helper.isNullOrEmpty(String.valueOf(studentId)) || 
            Helper.isNullOrEmpty(computerId) || 
            Helper.isNullOrEmpty(startTime) || 
            Helper.isNullOrEmpty(endTime) || 
            Helper.isNullOrEmpty(status)) {
            return null;
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
