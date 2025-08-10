package za.ac.cput;


import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Verification;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.VerificationFactory;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Repository.VerificationRepository;

public class Main {
    public static void main(String[] args) {

        Admin admin = AdminFactory.createAdmin("Lwazi", "Shozi", "lwazi@example.com", "EMP001");
        AdminRepository.getRepository().create(admin);
        System.out.println("Admin Created: " + admin);
        Verification verification = VerificationFactory.createVerification(admin.getUserId(), true);
        VerificationRepository.getRepository().create(verification);
        System.out.println("Verification Created: " + verification);
    }
}
