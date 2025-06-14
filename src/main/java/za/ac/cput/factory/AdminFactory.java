package za.ac.cput.factory;

import za.ac.cput.Domain.Admin;

import java.util.List;
import java.util.UUID;

public class AdminFactory {

    public static Admin createAdmin(String name, String email, String role, List<String> permissions) {
        String adminId = UUID.randomUUID().toString();

        return new Admin.Builder()
                .adminId(adminId)
                .name(name)
                .email(email)
                .role(role)
                .permissions(permissions)
                .build();
    }
}
