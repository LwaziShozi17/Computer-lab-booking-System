package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(String id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }
}
