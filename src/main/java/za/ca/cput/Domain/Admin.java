package za.ca.cput.Domain;
import java.util.*;

        public class Admin {

        private final String adminId;
        private final String name;
        private final String email;
        private final String role;
        private final List<String> permissions;

        private Admin(Builder builder) {
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
            return permissions.contains(action);
        }

        public void displayInfo() {
            System.out.println("Admin ID: " + adminId);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Role: " + role);
            System.out.println("Permissions: " + permissions);
        }
        public String getAdminId() {
            return adminId;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getRole() {
            return role;
        }
        public List<String> getPermissions() {
            return permissions;
        }
    }



