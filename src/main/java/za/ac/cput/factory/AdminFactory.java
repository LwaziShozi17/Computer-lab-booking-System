package za.ac.cput.factory;
/*
 * Main.java
 * Entry point for CPUT Computer Booking System
 * Author: Lwazi Shozi (Student Number: 230220061)
 * Date: 14 June 2025
 */
import za.ac.cput.Domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {

    public static Admin createAdmin(String firstName, String lastName, String email, String employeeId) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(employeeId)) {
            return null;
        }
        return new Admin.Builder()
                .setUserId(Helper.generateId())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setEmployeeId(employeeId)
                .build();
    }
}

