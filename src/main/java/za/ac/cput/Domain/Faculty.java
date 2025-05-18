package za.ac.cput.Domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
/*Faculty.java
Author: SM Thwabuse(220246009)
Date: 06 August 2025*/


@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @NotBlank(message = "Faculty ID is required")
    @Size(min = 2, max = 10, message = "Faculty ID must be between 2 and 10 characters")
    private String facultyId;

    @Column(name="faculty_id", nullable = false, length = 10, unique = true)
    private String faculty_id;

    @NotBlank(message = "Faculty name is required")
    @Size(min = 2, max = 50, message = "Faculty name must be between 2 and 50 characters")
    private String facultyName;

    protected Faculty() {

    }

    private Faculty(Builder builder) {
        this.facultyId = builder.facultyId;
        this.facultyName = builder.facultyName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }

    public static class Builder {
        private String facultyId;
        private String facultyName;

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }


        public Builder copy(Faculty faculty) {
            facultyId = faculty.facultyId;
            facultyName = faculty.facultyName;
            return this;
        }

        public Faculty build() {
            return new Faculty(this);

        }
    }
}
