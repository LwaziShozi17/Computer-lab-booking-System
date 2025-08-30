//package za.ac.cput.domain;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//@Entity
//public class Admin {
//    @Id
//    private Long adminId;
//    private String name;
//    private String surname;
//    private String email;
//    private String password;
//
//    protected Admin() {
//    }
//
//    private Admin(Builder builder) {
//        this.adminId = builder.adminId;
//        this.name = builder.name;
//        this.surname = builder.surname;
//        this.email = builder.email;
//        this.password = builder.password;
//    }
//
//    public Long getAdminId() {
//        return adminId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String toString() {
//        return "Admin{" +
//                "adminId=" + adminId +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//
//    //Builder Pattern
//    public static class Builder {
//        private Long adminId;
//        private String name;
//        private String surname;
//        private String email;
//        private String password;
//
//        public Builder setAdminId(Long adminId) {
//            this.adminId = adminId;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setSurname(String surname) {
//            this.surname = surname;
//            return this;
//        }
//
//        public Builder setEmail(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder setPassword(String password) {
//            this.password = password;
//            return this;
//        }
//
//
//        // Copy method
//        public Builder copy(Admin admin) {
//            this.adminId = admin.adminId;
//            this.name = admin.name;
//            this.surname = admin.surname;
//            this.email = admin.email;
//            this.password = admin.password;
//            return this;
//        }
//
//        public Admin build() {
//            return new Admin(this);
//        }
//    }
//}
