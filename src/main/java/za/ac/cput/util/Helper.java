package za.ac.cput.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    // Generate a unique ID using UUID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    // Validate email format
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, email);
    }

    // Validate that a string is not null or empty
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    // Format the current date and time
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    // Check if a string contains only letters (for names, etc.)
    public static boolean isAlpha(String input) {
        return input != null && input.matches("^[a-zA-Z]+$");
    }

    // Check if a string contains only digits (for IDs or years)
    public static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

}
