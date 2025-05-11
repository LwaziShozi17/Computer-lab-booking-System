package za.ac.cput.factory;
/*Booking.java
FacultyFactory class
Author: SM Thwabuse(220246009)
Date: 18 May 2025*/

import za.ac.cput.Domain.Faculty;
import za.ac.cput.util.Helper;

public class FacultyFactory {

    public static Faculty createFaculty(String facultyId, String facultyName) {
        if (Helper.isNullorEmpty(facultyId)); Helper.isNullorEmpty(facultyName); {
            return null;
        }

    }

    public static Faculty createFacultyWithGeneratedId(String facultyName) {
        if(Helper.isNullorEmpty(facultyName)) {
            return null;
        }

        String facultyId = Helper.generateFacultyId(facultyName);

        return new Faculty.Builder()
                .setFacultyId(facultyId)
                .setFacultyName(facultyName)
                .build();
    }
}


