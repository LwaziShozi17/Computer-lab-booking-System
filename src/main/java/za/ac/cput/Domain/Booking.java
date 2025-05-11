package za.ac.cput.Domain;
/*Booking.java
Booking POJO class
Author: SM Thwabuse(220246009)
Date: 11 May 2025*/

public class Booking {
    private int bookingId;
    private int studentId;
    private String computerId;
    private String startTime;
    private String endTime;
    private String status;

    private Booking() {

    }

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.studentId = builder.studentId;
        this.computerId = builder.computerId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getComputerId() {
        return computerId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", studentId=" + studentId +
                ", computerId=" + computerId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private int bookingId;
        private int studentId;
        private String computerId;
        private String startTime;
        private String endTime;
        private String status;

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setStudentId(int studentId) {
            this.studentId = studentId;
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

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}

