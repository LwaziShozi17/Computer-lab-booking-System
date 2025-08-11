package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.service.VerificationService;

import java.util.Map;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final AdminRepository adminRepository;

    public VerificationServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean verifyAdminCredentials(String email, String password) {
        return adminRepository.getAll().values().stream()
                .anyMatch(admin -> admin.getEmail().equalsIgnoreCase(email)
                        && admin.getPassword().equals(password)); // Replace with hashed password check in real-world apps
    }
}
