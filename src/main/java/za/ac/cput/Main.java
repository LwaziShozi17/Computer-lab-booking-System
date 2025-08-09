package za.ac.cput;


import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Verification;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.VerificationFactory;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.repository.VerificationRepository;

public class Main {
    public static void main(String[] args) {
        // Create Admin
        Admin admin = AdminFactory.createAdmin("Lwazi", "Shozi", "lwazi@example.com", "EMP001");
        AdminRepository.getRepository().create(admin);
        System.out.println("Admin Created: " + admin);

        // Create Verification
        Verification verification = VerificationFactory.createVerification(admin.getUserId(), true);
        VerificationRepository.getRepository().create(verification);
        System.out.println("Verification Created: " + verification);
    }
}
