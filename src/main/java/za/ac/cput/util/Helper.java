package za.ac.cput.util;

/*
 * Helper.java
 * Improved utility class for CPUT Computer Booking System
 * Author: Lwazi Shozi (Student Number: 230220061)
 * Date: 14 June 2025
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    // Constants for better maintainability
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String ALPHA_REGEX = "^[a-zA-Z\\s]+$";
    private static final String NUMERIC_REGEX = "^\\d+$";

    // Compiled patterns for better performance
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern ALPHA_PATTERN = Pattern.compile(ALPHA_REGEX);
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(NUMERIC_REGEX);

    // Private constructor to prevent instantiation
    private Helper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Generates a unique identifier using UUID
     * @return String representation of UUID
     */
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Validates email address format using improved regex pattern
     * @param email the email address to validate
     * @return true if email format is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    /**
     * Checks if string is null, empty, or contains only whitespace
     * @param input the string to check
     * @return true if input is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * Returns current date and time in default format
     * @return formatted current date time string
     */
    public static String getCurrentDateTime() {
        return getCurrentDateTime(DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * Returns current date and time in specified format
     * @param format the date time format pattern
     * @return formatted current date time string
     */
    public static String getCurrentDateTime(String format) {
        if (isNullOrEmpty(format)) {
            format = DEFAULT_DATE_TIME_FORMAT;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().format(formatter);
    }

    /**
     * Validates that input contains only alphabetic characters and spaces
     * @param input the string to validate
     * @return true if input contains only letters and spaces, false otherwise
     */
    public static boolean isAlpha(String input) {
        if (isNullOrEmpty(input)) {
            return false;
        }
        return ALPHA_PATTERN.matcher(input.trim()).matches();
    }

    /**
     * Validates that input contains only numeric digits
     * @param input the string to validate
     * @return true if input contains only digits, false otherwise
     */
    public static boolean isNumeric(String input) {
        if (isNullOrEmpty(input)) {
            return false;
        }
        return NUMERIC_PATTERN.matcher(input.trim()).matches();
    }

    /**
     * Validates that input is a valid positive integer
     * @param input the string to validate
     * @return true if input is a valid positive integer, false otherwise
     */
    public static boolean isPositiveInteger(String input) {
        if (!isNumeric(input)) {
            return false;
        }
        try {
            return Integer.parseInt(input.trim()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates student number format (assuming 9-digit format for CPUT)
     * @param studentNumber the student number to validate
     * @return true if student number format is valid, false otherwise
     */
    public static boolean isValidStudentNumber(String studentNumber) {
        if (isNullOrEmpty(studentNumber)) {
            return false;
        }
        String cleaned = studentNumber.trim();
        return cleaned.matches("^\\d{9}$"); // 9-digit student number
    }

    /**
     * Sanitizes input string by trimming whitespace and converting to title case
     * @param input the string to sanitize
     * @return sanitized string or empty string if input is null
     */
    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        return toTitleCase(input.trim());
    }

    /**
     * Converts string to title case (first letter of each word capitalized)
     * @param input the string to convert
     * @return title case string
     */
    public static String toTitleCase(String input) {
        if (isNullOrEmpty(input)) {
            return input;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }
}