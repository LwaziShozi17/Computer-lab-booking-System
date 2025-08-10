package za.ac.cput.Domain;

import java.util.Objects;


public class Computer {
    private String computerId;
    private String labId;
    private String faculty;
    private String status; // "Empty" or "Occupied"
    private String software;

    protected Computer() {}

    private Computer(Builder builder) {
        this.computerId = builder.computerId;
        this.labId = builder.labId;
        this.faculty = builder.faculty;
        this.status = builder.status;
        this.software = builder.software;
    }

    // Getters
    public String getComputerId() { return computerId; }
    public String getLabId() { return labId; }
    public String getFaculty() { return faculty; }
    public String getStatus() { return status; }
    public String getSoftware() { return software; }

    // Builder Pattern
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

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(computerId, computer.computerId) &&
                Objects.equals(labId, computer.labId) &&
                Objects.equals(faculty, computer.faculty) &&
                Objects.equals(status, computer.status) &&
                Objects.equals(software, computer.software);
    }

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
}