package za.ac.cput.service;

import za.ac.cput.Domain.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin getAdminById(String id);
    Admin getAdminByEmail(String email);
    List<Admin> getAllAdmins();
    Admin updateAdmin(Admin admin);
    void deleteAdmin(String id);
}
