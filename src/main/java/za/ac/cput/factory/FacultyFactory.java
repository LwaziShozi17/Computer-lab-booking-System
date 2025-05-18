package za.ac.cput.factory;


import za.ac.cput.Domain.Faculty;
import za.ac.cput.util.Helper;

public class FacultyFactory {

    public static Faculty createFaculty(String facultyName) {
        if (Helper.isNullOrEmpty(facultyName) || facultyName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid faculty name");
        }


        String facultyId =  "FAC-" +
                facultyName.substring(0, 3).toUpperCase() + "-" +
                String.format("%04d", (int)(Math.random() * 10000));

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName.trim())
                .build();
    }

    public static Faculty createFacultyWithId(String facultyId, String facultyName) {
        if (!Helper.isValidFacultyId(facultyId)) {
            throw new IllegalArgumentException("Invalid faculty ID format");
        }
        if (Helper.isNullOrEmpty(facultyName) || facultyName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid faculty name");
        }

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName.trim())
                .build();
    }
}

