package za.ac.cput.util;

import java.util.regex.Pattern;

public class Helper {
    
    // Email validation pattern
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    
    // Phone number validation pattern (South African format)
    private static final Pattern PHONE_PATTERN = Pattern.compile(
        "^(\\+27|0)[6-8][0-9]{8}$"
    );
    
    // ID number validation pattern (South African ID)
    private static final Pattern ID_PATTERN = Pattern.compile(
        "^[0-9]{13}$"
    );
    
    /**
     * Validates if a string is not null or empty
     * @param str the string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Validates email format
     * @param email the email to validate
     * @return true if valid email format, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validates phone number format
     * @param phone the phone number to validate
     * @return true if valid phone format, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        return !isNullOrEmpty(phone) && PHONE_PATTERN.matcher(phone).matches();
    }
    
    /**
     * Validates South African ID number
     * @param idNumber the ID number to validate
     * @return true if valid ID format, false otherwise
     */
    public static boolean isValidIdNumber(String idNumber) {
        return !isNullOrEmpty(idNumber) && ID_PATTERN.matcher(idNumber).matches();
    }
    
    /**
     * Generates a random ID
     * @return a random long value as string
     */
    public static String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }
    
    /**
     * Truncates a string to specified length
     * @param str the string to truncate
     * @param maxLength maximum length
     * @return truncated string
     */
    public static String truncateString(String str, int maxLength) {
        if (isNullOrEmpty(str)) return str;
        return str.length() <= maxLength ? str : str.substring(0, maxLength) + "...";
    }
    
    /**
     * Formats a string to title case
     * @param str the string to format
     * @return formatted string in title case
     */
    public static String toTitleCase(String str) {
        if (isNullOrEmpty(str)) return str;
        
        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder titleCase = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        
        return titleCase.toString().trim();
    }
    
    /**
     * Validates if a number is positive
     * @param number the number to validate
     * @return true if positive, false otherwise
     */
    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }
    
    /**
     * Validates if a string contains only letters
     * @param str the string to validate
     * @return true if only letters, false otherwise
     */
    public static boolean isOnlyLetters(String str) {
        return str != null && str.matches("[a-zA-Z\\s]+");
    }
    
    /**
     * Validates if a string contains only numbers
     * @param str the string to validate
     * @return true if only numbers, false otherwise
     */
    public static boolean isOnlyNumbers(String str) {
        return str != null && str.matches("\\d+");
    }
}
