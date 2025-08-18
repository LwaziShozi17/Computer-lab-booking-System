package za.ac.cput.Factory;

import za.ac.cput.Domain.Faculty;
import za.ac.cput.util.Helper;

public class FacultyFactory {
    public static Faculty createFaculty(String facultyId, String facultyName) {
        if (Helper.isNullOrEmpty(facultyId) || Helper.isNullOrEmpty(facultyName)) {
            return null;
        }
        
        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName)
                .build();
    }
}
