package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long studentId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "faculty", nullable = false)
    private String faculty;
    @Column(name = "enrollment_year", nullable = false)
    private String enrollmentYear;
    @Column(name = "current_year", nullable = false)
    private String currentYear;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    protected Student() {}

    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.faculty = builder.faculty;
        this.enrollmentYear = builder.enrollmentYear;
        this.currentYear = builder.currentYear;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Getters
    public Long getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFaculty() { return faculty; }
    public String getEnrollmentYear() { return enrollmentYear; }
    public String getCurrentYear() { return currentYear; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", currentYear='" + currentYear + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder class for Student
    public static class Builder {
        private Long studentId;
        private String firstName;
        private String lastName;
        private String faculty;
        private String enrollmentYear;
        private String currentYear;
        private String email;
        private String password;

        // setters for Builder
        public Builder setStudentId(Long studentId) {
            this.studentId = studentId;
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

        public Builder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder setEnrollmentYear(String enrollmentYear) {
            this.enrollmentYear = enrollmentYear;
            return this;
        }

        public Builder setCurrentYear(String currentYear) {
            this.currentYear = currentYear;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        // builder copy method
        public Builder copy(Student student) {
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.email = student.email;
            this.password = student.password;
            this.studentId = student.studentId;
            this.faculty = student.faculty;
            this.enrollmentYear = student.enrollmentYear;
            this.currentYear = student.currentYear;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
