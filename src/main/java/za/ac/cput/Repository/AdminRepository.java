package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
import java.util.HashMap;
import java.util.Map;

public class AdminRepository {
    private static AdminRepository repository = null;
    private Map<String, Admin> adminDB;

    private AdminRepository() {
        adminDB = new HashMap<>();
    }

    public static AdminRepository getRepository() {
        if (repository == null) {
            repository = new AdminRepository();
        }
        return repository;
    }

    public Admin create(Admin admin) {
        adminDB.put(admin.getUserId(), admin);
        return admin;
    }

    public Admin read(String userId) {
        return adminDB.get(userId);
    }

    public Admin update(Admin admin) {
        if (adminDB.containsKey(admin.getUserId())) {
            adminDB.put(admin.getUserId(), admin);
            return admin;
        }
        return null;
    }

    public boolean delete(String userId) {
        return adminDB.remove(userId) != null;
    }
}
