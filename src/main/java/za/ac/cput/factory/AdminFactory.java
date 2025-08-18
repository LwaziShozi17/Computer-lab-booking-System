package za.ac.cput.Factory;
/*
 * Main.java
 * Entry point for CPUT Computer Booking System
 * Author: Lwazi Shozi (Student Number: 230220061)
 * Date: 14 June 2025
 */
import za.ac.cput.Domain.Admin;
import za.ac.cput.util.Helper;

import java.util.List;

public class AdminFactory {

    public static Admin createAdmin(String firstName, String lastName, String email, String password, String employeeId, List<String> permissions) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || 
            Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || 
            Helper.isNullOrEmpty(employeeId)) {
            return null;
        }
        
        if (!Helper.isValidEmail(email)) {
            return null;
        }
        
        return new Admin.Builder()
                .setUserId(Helper.generateId())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setEmployeeId(employeeId)
                .setPermissions(permissions != null ? permissions : List.of())
                .build();
    }
}

