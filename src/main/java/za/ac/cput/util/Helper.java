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
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String ALPHA_REGEX = "^[a-zA-Z\\s]+$";
    private static final String NUMERIC_REGEX = "^\\d+$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern ALPHA_PATTERN = Pattern.compile(ALPHA_REGEX);
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(NUMERIC_REGEX);

    private Helper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }


    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String getCurrentDateTime() {
        return getCurrentDateTime(DEFAULT_DATE_TIME_FORMAT);
    }
    public static String getCurrentDateTime(String format) {
        if (isNullOrEmpty(format)) {
            format = DEFAULT_DATE_TIME_FORMAT;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().format(formatter);
    }


    public static boolean isAlpha(String input) {
        if (isNullOrEmpty(input)) {
            return false;
        }
        return ALPHA_PATTERN.matcher(input.trim()).matches();
    }

    public static boolean isNumeric(String input) {
        if (isNullOrEmpty(input)) {
            return false;
        }
        return NUMERIC_PATTERN.matcher(input.trim()).matches();
    }
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
    public static boolean isValidStudentNumber(String studentNumber) {
        if (isNullOrEmpty(studentNumber)) {
            return false;
        }
        String cleaned = studentNumber.trim();
        return cleaned.matches("^\\d{9}$"); // 9-digit student number
    }

    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        return toTitleCase(input.trim());
    }
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