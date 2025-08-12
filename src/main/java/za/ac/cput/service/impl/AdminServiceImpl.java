package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.service.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl() {
        this.adminRepository = AdminRepository.getRepository();
    }

    @Override
    public Admin create(Admin admin) {
        return adminRepository.create(admin);
    }

    @Override
    public Optional<Admin> read(String adminId) {
        Admin admin = adminRepository.read(adminId);
        return Optional.ofNullable(admin);
    }

    @Override
    public List<Admin> getAll() {
        return new ArrayList<>(adminRepository.getAll().values());
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.update(admin);
    }

    @Override
    public boolean delete(String adminId) {
        return adminRepository.delete(adminId);
    }
}
