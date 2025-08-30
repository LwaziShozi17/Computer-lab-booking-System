/*
Booking.java
Booking Domain class
Author: SE Sibiya (230975623)
Date: 20 August 2025
*/

package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookingId", unique = true, nullable = false)
    private Long bookingId;

    @Column(name = "student", nullable = false)
    private Long studentId;

    @Column(name = "faculty", nullable = false)
    private String faculty;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "computer_id", nullable = false)
    private String computerId;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "software", nullable = false)
    private String software;

    protected Booking() {}

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.studentId = builder.studentId;
        this.faculty = builder.faculty;
        this.course = builder.course;
        this.computerId = builder.computerId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.software = builder.software;
    }

    // Getters
    public Long getBookingId() { return bookingId; }
    public long getStudentId() { return studentId; }
    public String getFaculty() { return faculty; }
    public String getCourse() { return course; }
    public String getComputerId() { return computerId; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getSoftware() { return software; }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", studentId=" + studentId +
                ", faculty='" + faculty + '\'' +
                ", course='" + course + '\'' +
                ", computerId='" + computerId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", software='" + software + '\'' +
                '}';
    }

    // Builder Class
    public static class Builder {
        private Long bookingId;
        private long studentId;
        private String faculty;
        private String course;
        private String computerId;
        private String startTime;
        private String endTime;
        private String software;

        public Builder setBookingId(Long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setStudentId(long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder setComputerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setSoftware(String software) {
            this.software = software;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.studentId = booking.studentId;
            this.faculty = booking.faculty;
            this.course = booking.course;
            this.computerId = booking.computerId;
            this.startTime = booking.startTime;
            this.endTime = booking.endTime;
            this.software = booking.software;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
