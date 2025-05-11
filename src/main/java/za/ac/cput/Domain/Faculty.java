
package za.ac.cput.Domain;
/*Booking.java
Booking POJO class
Author: SM Thwabuse(220246009)
Date: 11 May 2025*/

public class Faculty {
    private String facultyId;
    private String facultyName;

    private Faculty() {

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
