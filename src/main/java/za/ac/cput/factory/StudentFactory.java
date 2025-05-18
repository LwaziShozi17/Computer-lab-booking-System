package za.ac.cput.factory;

import za.ac.cput.Domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String firstName, String lastName,
                                        String email, String password,
                                        String faculty, String enrollmentYear,
                                        String currentYear) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First and last name are required");
        }

        return new Student.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setStudentId("STD -" + Helper.generateId()) // Now works!
                .setFaculty(faculty)
                .setEnrollmentYear(enrollmentYear)
                .setCurrentYear(currentYear)
                .build();
    }
}