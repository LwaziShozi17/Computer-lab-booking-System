package za.ac.cput.Domain;

import java.time.LocalDate;
/* Report.java
Report POJO class
Author: Z Jantjies (222809825)
Date: 11 May 2025 */

public class Report {
    private final String reportId;
    private final LocalDate generateDate;
    private final String reportType;
    private final String adminId;
    private final String computerId;

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.generateDate = builder.generateDate;
        this.reportType = builder.reportType;
        this.adminId = builder.adminId;
        this.computerId = builder.computerId;
    }

    //  Getters
    public String getReportId() { return reportId; }
    public LocalDate getGenerateDate() { return generateDate; }
    public String getReportType() { return reportType; }
    public String getAdminId() { return adminId; }
    public String getComputerId() { return computerId; }

    //  Domain Logic
    public boolean isMaintenanceReport() {
        return "Maintenance".equalsIgnoreCase(reportType);
    }

    // Standard Methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return reportId.equals(report.reportId);
    }

    @Override
    public String toString() {
        return String.format(
                "Report[ID=%s, Type=%s, Date=%s]",
                reportId, reportType, generateDate
        );
    }

    //  Builder Pattern
    public static class Builder {
        private String reportId;
        private LocalDate generateDate;
        private String reportType;
        private String adminId;
        private String computerId;

        public Builder reportId(String reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder generateDate(LocalDate generateDate) {
            this.generateDate = generateDate;
            return this;
        }

        public Builder reportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder adminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder computerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Report build() {
            // Manual validation
            if (reportId == null || reportId.trim().isEmpty()) {
                throw new IllegalArgumentException("Report ID required");
            }
            if (generateDate == null) {
                generateDate = LocalDate.now(); // Default to current date
            }
            if (reportType == null || reportType.trim().isEmpty()) {
                throw new IllegalArgumentException("Report type required");
            }

            return new Report(this);
        }
    }
}