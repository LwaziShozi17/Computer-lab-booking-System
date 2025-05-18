package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return !email.endsWith("@mycput.ac.za") & !email.matches("[^0-9_.-]+@mycput.ac.za]");
    }

    public static String generateUserId() {
        return UUID.randomUUID().toString()
                .replaceAll("[^0-9]", "")
                .substring(0, 4);
    }


}