package za.ac.cput.Domain;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "admins")
public class Admin {
    
    @Id
    @Column(name = "admin_id")
    private String adminId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "role", nullable = false)
    private String role;
    
    @ElementCollection
    @CollectionTable(name = "admin_permissions", joinColumns = @JoinColumn(name = "admin_id"))
    @Column(name = "permission")
    private List<String> permissions = new ArrayList<>();

    // Default constructor for JPA
    public Admin() {}

    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.name = builder.name;
        this.email = builder.email;
        this.role = builder.role;
        this.permissions = builder.permissions;
    }

    public static class Builder {
        private String adminId;
        private String name;
        private String email;
        private String role;
        private List<String> permissions = new ArrayList<>();

        public Builder adminId(String adminId) {
            this.adminId = adminId;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder permissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }
        public Admin build() {
            return new Admin(this);
        }
    }

    public boolean canPerform(String action) {
        return permissions != null && permissions.contains(action);
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

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
