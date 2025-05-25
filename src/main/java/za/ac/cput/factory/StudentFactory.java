/*
StudentFactory.java
Student Factory class
Author: SE Sibiya (230975623)
Date: 18 May 2025
*/

package za.ac.cput.factory;

import za.ac.cput.Domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String firstName, String lastName,
                                        String email, String password, String studentId,
                                        String faculty, String enrollmentYear,
                                        String currentYear) {

        //Checking empty fields
        if (Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(studentId)
                || Helper.isNullOrEmpty(faculty)
                || Helper.isNullOrEmpty(enrollmentYear)
                || Helper.isNullOrEmpty(currentYear)) {
            throw new IllegalArgumentException("Please fill all the required fields");
        }
        //Checking if it is the right email
        if (Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Incorrect email domain");
        }

        return new Student.Builder()
                .setUserId(Helper.generateUserId())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setStudentId(studentId)
                .setFaculty(faculty)
                .setEnrollmentYear(enrollmentYear)
                .setCurrentYear(currentYear)
                .build();
    }
}