package za.ac.cput;

import za.ac.cput.Domain.Admin;
//import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.factory.AdminFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static za.ac.cput.factory.AdminFactory AdminFactory;

    public static void main(String[] args) {
        // Define permissions manually
        List<String> permissions = Arrays.asList(
                "CREATE_BOOKING",
                "VIEW_BOOKINGS",
                "MANAGE_USERS",
                "VERIFY_USER"
        );

        Admin admin = AdminFactory.createAdmin(
                "Lwazi Shozi",
                "230220061@cput.ac.za",
                "System Admin",
                permissions
        );

        AdminRepository repo = AdminRepository.getRepository();
        repo.create(admin);

        // Display admin details manually
        System.out.println("==== Admin Info ====");
        System.out.println("Admin ID: " + admin.getAdminId());
        System.out.println("Name: " + admin.getName());
        System.out.println("Email: " + admin.getEmail());
        System.out.println("Role: " + admin.getRole());
        System.out.println("Permissions: " + admin.getPermissions());
        System.out.println("====================");

        // Check permission
        System.out.println("Can perform 'MANAGE_USERS'? " + admin.canPerform("MANAGE_USERS"));
    }
}
