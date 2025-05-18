package za.ac.cput.Domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;


/*Booking.java
Booking class
Author: SM Thwabuse(220246009)
Date: 06 August 2025
*/
@Entity
@Table(name = "booking")

public class Booking {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @NotNull(message= "Student ID required")
    @Column(nullable = false)
    private int studentId;

    @NotBlank(message = "Computer ID required")
    @Column(nullable = false)
    private String computerId;

    @FutureOrPresent(message = "Start time must be in the present or future")
    @Column(nullable = false)
    private LocalDateTime startTime;

    @Future(message = "End time must be in the future")
    @Column(nullable = false)
    private LocalDateTime endTime;

    @NotBlank(message = "Status required")
    @Column(nullable = false)
    private String status;

    protected Booking() {
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
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
        private LocalDateTime startTime;
        private LocalDateTime endTime;
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

        public Builder setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.studentId = booking.studentId;
            this.computerId = booking.computerId;
            this.startTime = booking.startTime;
            this.endTime = booking.endTime;
            this.status = booking.status;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}


