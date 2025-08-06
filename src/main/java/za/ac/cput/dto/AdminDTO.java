package za.ac.cput.dto;

import java.util.List;

public class AdminDTO {
    private String adminId;
    private String name;
    private String email;
    private String role;
    private List<String> permissions;

    public AdminDTO() {}

    public AdminDTO(String adminId, String name, String email, String role, List<String> permissions) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.permissions = permissions;
    }

    // Getters and Setters
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
