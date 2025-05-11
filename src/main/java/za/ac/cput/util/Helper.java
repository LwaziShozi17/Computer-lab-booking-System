package za.ac.cput.util;

import java.util.UUID;

public class Helper {

    public static boolean isNullorEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidFacultyId(String facultyId) {
        return facultyId != null && facultyId.matches("^FAC-[A-Z]{3,20}$");
    }

    public static String generateFacultyId(String facultyName) {
        if (isNullorEmpty(facultyName)) {
            return null;
        }

        String[] words = facultyName.split(" ");
        StringBuilder initials = new StringBuilder("FAC-");

        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.substring(0,1).toUpperCase());
            }
        }

        return initials.toString() + "-" + UUID.randomUUID().toString().substring(0,5);
    }


}