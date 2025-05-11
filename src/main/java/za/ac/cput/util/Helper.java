package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w-23.]+@");
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String hashPassword(String password) {
        // Implement proper password hashing (e.g., BCrypt)
        return password; // placeholder - use real hashing
    }
}