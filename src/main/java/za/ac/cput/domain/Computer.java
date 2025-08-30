package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Computer {
    @Id
    private String computerId;
    private String labId;
    private String faculty;
    private String status;
    private String software;

    protected Computer() {
    }

    private Computer(Builder builder) {
        this.computerId = builder.computerId;
        this.labId = builder.labId;
        this.faculty = builder.faculty;
        this.status = builder.status;
        this.software = builder.software;
    }

    public String getComputerId() {
        return computerId;
    }
    public String getLabId() {
        return labId;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getStatus() {
        return status;
    }
    public String getSoftware() {
        return software;
    }

    // tioString
    @Override
    public String toString() {
        return "Computer{" +
                "computerId='" + computerId + '\'' +
                ", labId='" + labId + '\'' +
                ", faculty='" + faculty + '\'' +
                ", status='" + status + '\'' +
                ", software='" + software + '\'' +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String computerId;
        private String labId;
        private String faculty;
        private String status;
        private String software;

        public Builder setComputerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Builder setLabId(String labId) {
            this.labId = labId;
            return this;
        }

        public Builder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setSoftware(String software) {
            this.software = software;
            return this;
        }

        // Copy method
        public Builder copy(Computer computer) {
            this.computerId = computer.computerId;
            this.labId = computer.labId;
            this.faculty = computer.faculty;
            this.status = computer.status;
            this.software = computer.software;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }

}
