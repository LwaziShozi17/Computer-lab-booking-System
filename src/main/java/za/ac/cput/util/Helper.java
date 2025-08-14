package za.ac.cput.util;
/*
 * Main.java
 * Entry point for CPUT Computer Booking System
 * Author: Lwazi Shozi (Student Number: 230220061)
 * Date: 14 June 2025
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;
/*
 * Main.java
 * Entry point for CPUT Computer Booking System
 * Author: Lwazi Shozi (Student Number: 230220061)
 * Date: 14 June 2025
 */
public class Helper {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, email);
    }
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
    public static boolean isAlpha(String input) {
        return input != null && input.matches("^[a-zA-Z]+$");
    }
    public static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

}
