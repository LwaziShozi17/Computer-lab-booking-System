package za.ac.cput.Factory;

import za.ac.cput.Domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String studentId, String faculty, 
                                      String enrollmentYear, String currentYear,
                                      String firstName, String lastName, String email, String password) {
        if (Helper.isNullOrEmpty(studentId) || 
            Helper.isNullOrEmpty(faculty) || 
            Helper.isNullOrEmpty(enrollmentYear) || 
            Helper.isNullOrEmpty(currentYear) || 
            Helper.isNullOrEmpty(firstName) || 
            Helper.isNullOrEmpty(lastName) || 
            Helper.isNullOrEmpty(email) || 
            Helper.isNullOrEmpty(password)) {
            return null;
        }
        
        return new Student.Builder()
                .setStudentId(studentId)
                .setFaculty(faculty)
                .setEnrollmentYear(enrollmentYear)
                .setCurrentYear(currentYear)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
