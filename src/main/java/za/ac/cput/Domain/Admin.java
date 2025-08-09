package za.ac.cput.Domain;

import jakarta.persistence.*;
import za.ac.cput.Domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Admin entity representing system administrators who manage bookings and verifications.
 * Extends the User class and adds employee-specific details and permissions.
 */
@Entity
@Table(name = "admins")
public class Admin extends User {

    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "admin_permissions", joinColumns = @JoinColumn(name = "admin_id"))
    @Column(name = "permission")
    private List<String> permissions = new ArrayList<>();

    // Default constructor required by JPA
    protected Admin() {
        super(); // Calls User's no-args constructor
    }

    // Builder-based constructor
    private Admin(Builder builder) {
        super();
        this.employeeId = builder.employeeId;
        this.permissions = builder.permissions != null ? new ArrayList<>(builder.permissions) : new ArrayList<>();
    }

    // --- Domain Logic ---
    public boolean canPerform(String action) {
        return permissions != null && permissions.contains(action);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    // --- Builder Pattern ---
    public static class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String employeeId;
        private List<String> permissions;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setPermissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        public Builder copy(Admin admin) {
            this.userId = admin.getUserId();
            this.firstName = admin.getFirstName();
            this.lastName = admin.getLastName();
            this.email = admin.getEmail();
            this.employeeId = admin.employeeId;
            this.permissions = new ArrayList<>(admin.permissions);
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                "employeeId='" + employeeId + '\'' +
                ", permissions=" + permissions +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(employeeId, admin.employeeId) &&
                Objects.equals(permissions, admin.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, permissions);
    }
}
