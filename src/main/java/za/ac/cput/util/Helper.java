package za.ac.cput.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidFacultyId(String facultyId) {
        return facultyId != null && facultyId.matches("^FAC-[A-Z]{3,20}-\\d{4}$");
    }

    public static String generateFacultyId(String facultyName) {
        if (isNullOrEmpty(facultyName) || facultyName.trim().length() < 2) {
            throw new IllegalArgumentException("Faculty name must be at least 2 characters long");
        }

        // Format: FAC-<Initials>-<Random>
        String[] words = facultyName.trim().split("\\s+");
        StringBuilder initials = new StringBuilder("FAC-");

        // Get first letter of each word (minimum 2 letters)
        for (int i = 0; i < Math.min(words.length, 3); i++) {
            if (!words[i].isEmpty()) {
                initials.append(words[i].substring(0, 1).toUpperCase());
            }
        }

        // Ensure we have at least 2 initials
        if (initials.length() < 6) { // "FAC-X" needs another letter
            initials.append("X");
        }

        return initials + "-" + UUID.randomUUID().toString().substring(0, 4);
    }

    public static boolean isValidBookingId(int bookingId) {
        return bookingId >= 1000 && bookingId <= 9999; // Validate 4-digit range
    }

    public static boolean isValidBooking(int studentId, String computerId,
                                         LocalDateTime startTime, LocalDateTime endTime,
                                         String status) {
        return studentId > 0 &&
                !isNullOrEmpty(computerId) &&
                computerId.matches("^COM-\\d+$") &&
                startTime != null &&
                endTime != null &&
                endTime.isAfter(startTime) &&
                !isNullOrEmpty(status) &&
                (status.equals("CONFIRMED") || status.equals("CANCELLED") || status.equals("BOOKED"));
    }

    public static boolean isValidComputerId(String computerId) {
        return computerId != null && computerId.matches("^COM-\\d{3}$");
    }

    public static boolean isValidStatus(String status) {
        return status != null &&
                (status.equals("CONFIRMED") ||
                        status.equals("CANCELLED") ||
                        status.equals("BOOKED"));
    }

    public static int generateBookingId() {
        return 1000 + (int)(Math.random() * 9000); // Generates 4-digit ID (1000-9999)
    }


    public static boolean isValidFacultyName(String facultyName) {
        return true;
    }
}