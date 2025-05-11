package za.ac.cput.Domain;

/* Computer.java
Computer POJO class
Author: Z Jantjies (222809825)
Date: 11 May 2025 */

public class Computer {
    private final String computerId;
    private final String labId;
    private final String faculty;
    private final String status;
    private final String software;

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

    // Domain Logic
    public boolean isAvailable() {
        return "Empty".equals(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return computerId.equals(computer.computerId);
    }

    @Override
    public String toString() {
        return String.format(
                "Computer[ID=%s, Lab=%s, Status=%s]",
                computerId, labId, status
        );
    }

    public static class Builder {
        private String computerId;
        private String labId;
        private String faculty;
        private String status;
        private String software;

        public Builder computerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Builder labId(String labId) {
            this.labId = labId;
            return this;
        }

        public Builder faculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder software(String software) {
            this.software = software;
            return this;
        }

        public Computer build() {
            // Manual validation (no Helper class)
            if (computerId == null || computerId.trim().isEmpty()) {
                throw new IllegalArgumentException("Computer ID required");
            }
            if (labId == null || labId.trim().isEmpty()) {
                throw new IllegalArgumentException("Lab ID required");
            }
            if (!"Occupied".equals(status) && !"Empty".equals(status)) {
                throw new IllegalArgumentException("Status must be 'Occupied' or 'Empty'");
            }

            return new Computer(this);
        }
    }
}