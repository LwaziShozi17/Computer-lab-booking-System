/*   Helper.java
     Helper class
     Author: SE Sibiya (230975623)
     Date: 25 May 2025 */

package za.ac.cput.util;

import java.util.Random;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return !email.endsWith("@mycput.ac.za") & !email.matches("[^0-9_.-]+@mycput.ac.za]");
    }

    public static String generatedId() {
        return UUID.randomUUID().toString()
                .replaceAll("[^0-9]", "")
                .substring(0, 4);
    }

    // ✅ Generate bookingId: exactly 4 digits
    public static Long generateBookingId() {
        Random rand = new Random();
        return (long) (10000 + rand.nextInt(90000)); // range 1000–9999
    }
    // ✅ Validate bookingId: must be 4 digits
    public static boolean isValidBookingId(Long bookingId) {
        return bookingId != null && bookingId.toString().matches("\\d{4}");
    }

}