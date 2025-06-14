/*   Student.java
     Student domain class
     Author: SE Sibiya (230975623)
     Date: 10 May 2025 */

package za.ac.cput.Domain;

public class Student extends User {
    private String studentId;
    private String faculty;
    private String enrollmentYear;
    private String currentYear;

    private Student() {
    } //Default constructor

    //Constructor with parameter using builder
    private Student(Builder builder) {
        super(builder);
        this.studentId = builder.studentId;
        this.faculty = builder.faculty;
        this.enrollmentYear = builder.enrollmentYear;
        this.currentYear = builder.currentYear;
    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", faculty='" + faculty + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", currentYear='" + currentYear + '\'' +
                '}';
    }


    public static class Builder extends User.Builder {
        private String studentId;
        private String faculty;
        private String enrollmentYear;
        private String currentYear;


        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
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

        public Builder copy(Student student) {
            super.copy(student);
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
