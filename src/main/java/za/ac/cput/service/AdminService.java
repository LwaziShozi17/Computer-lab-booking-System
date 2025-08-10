package za.ac.cput.service;

import za.ac.cput.Domain.Admin;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin create(Admin admin);
    Optional<Admin> read(String adminId);
    List<Admin> getAll();
    Admin update(Admin admin);
    boolean delete(String adminId);
}
