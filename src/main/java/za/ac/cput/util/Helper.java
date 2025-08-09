package za.ac.cput.util;

/*
 Helper class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.Objects;

public final class Helper {
    private Helper() {}

    // Pre-compiled patterns for better performance
    private static final Pattern FACULTY_ID_PATTERN = Pattern.compile("^FAC-[A-Z]{3,20}-\\d{4}$");
    private static final Pattern COMPUTER_ID_PATTERN = Pattern.compile("^COM-\\d{3}$");
    private static final String[] VALID_STATUSES = {"CONFIRMED", "CANCELLED", "BOOKED"};

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isValidFacultyId(String facultyId) {
        return facultyId != null && FACULTY_ID_PATTERN.matcher(facultyId).matches();
    }

    public static boolean isValidComputerId(String computerId) {
        return computerId != null && COMPUTER_ID_PATTERN.matcher(computerId).matches();
    }

    public static boolean isValidStatus(String status) {
        if (status == null) return false;
        for (String validStatus : VALID_STATUSES) {
            if (validStatus.equals(status)) return true;
        }
        return false;
    }

    public static boolean isValidBooking(int studentId, String computerId,
                                         LocalDateTime startTime, LocalDateTime endTime,
                                         String status) {
        return studentId > 0 &&
                isValidComputerId(computerId) &&
                startTime != null &&
                endTime != null &&
                endTime.isAfter(startTime) &&
                isValidStatus(status);
    }

    public static boolean isValidBookingId(int bookingId) {
        return bookingId >= 1000 && bookingId <= 9999;
    }

    public static int generateBookingId() {
        return ThreadLocalRandom.current().nextInt(1000, 10000);
    }
}