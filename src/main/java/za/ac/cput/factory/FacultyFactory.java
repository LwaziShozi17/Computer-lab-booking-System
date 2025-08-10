package za.ac.cput.factory;

/*
 FacultyFactory class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import za.ac.cput.Domain.Faculty;
import za.ac.cput.util.Helper;

import java.util.Objects;

public final class FacultyFactory {
    private FacultyFactory() {} // Prevent instantiation

    public static Faculty createFaculty(String facultyName) {
        Objects.requireNonNull(facultyName, "Faculty name cannot be null");
        String trimmedName = facultyName.trim();
        if (trimmedName.length() < 3) {
            throw new IllegalArgumentException("Faculty name must be at least 3 characters");
        }

        String facultyId = generateFacultyId(trimmedName);

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(trimmedName)
                .build();
    }

    public static Faculty createFacultyWithId(String facultyId, String facultyName) {
        if (!Helper.isValidFacultyId(facultyId)) {
            throw new IllegalArgumentException("Invalid faculty ID format");
        }
        Objects.requireNonNull(facultyName, "Faculty name cannot be null");
        String trimmedName = facultyName.trim();
        if (trimmedName.length() < 3) {
            throw new IllegalArgumentException("Faculty name must be at least 3 characters");
        }

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(trimmedName)
                .build();
    }

    private static String generateFacultyId(String facultyName) {
        String[] words = facultyName.split("\\s+");
        StringBuilder initials = new StringBuilder("FAC-");

        for (int i = 0; i < Math.min(words.length, 3); i++) {
            if (!words[i].isEmpty()) {
                initials.append(words[i].charAt(0));
            }
        }
        if (initials.length() < 6) {
            initials.append("X");
        }
        return initials.append("-")
                .append((int) (Math.random() * 9000) + 1000)
                .toString();
    }
}