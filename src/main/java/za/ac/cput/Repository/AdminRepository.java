package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;

import java.util.*;

public class AdminRepository {

    private static AdminRepository repository = null;
    private final Map<String, Admin> adminDB;

    private AdminRepository() {
        this.adminDB = new HashMap<>();
    }

    public static AdminRepository getRepository() {
        if (repository == null)
            repository = new AdminRepository();
        return repository;
    }

    public Admin create(Admin admin) {
        adminDB.put(admin.getAdminId(), admin);
        return admin;
    }

    public Admin read(String adminId) {
        return adminDB.get(adminId);
    }

    public Admin update(Admin admin) {
        if (adminDB.containsKey(admin.getAdminId())) {
            adminDB.put(admin.getAdminId(), admin);
            return admin;
        }
        return null;
    }

    public boolean delete(String adminId) {
        return adminDB.remove(adminId) != null;
    }

    public List<Admin> getAll() {
        return new ArrayList<>(adminDB.values());
    }
}
