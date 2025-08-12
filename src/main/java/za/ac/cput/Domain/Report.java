package za.ac.cput.Domain;

import java.time.LocalDate;
import java.util.Objects;


public class Report {
    private String reportId;
    private LocalDate generateDate;
    private String reportType;
    private String adminId;
    private String computerId;

    protected Report() {}

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.generateDate = builder.generateDate;
        this.reportType = builder.reportType;
        this.adminId = builder.adminId;
        this.computerId = builder.computerId;
    }

    public String getReportId() {
        return reportId;
    }

    public LocalDate getGenerateDate() {
        return generateDate;
    }

    public String getReportType() {
        return reportType;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getComputerId() {
        return computerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(reportId, report.reportId) &&
                Objects.equals(generateDate, report.generateDate) &&
                Objects.equals(reportType, report.reportType) &&
                Objects.equals(adminId, report.adminId) &&
                Objects.equals(computerId, report.computerId);
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId='" + reportId + '\'' +
                ", generateDate=" + generateDate +
                ", reportType='" + reportType + '\'' +
                ", adminId='" + adminId + '\'' +
                ", computerId='" + computerId + '\'' +
                '}';
    }

    public static class Builder {
        private String reportId;
        private LocalDate generateDate;
        private String reportType;
        private String adminId;
        private String computerId;

        public Builder setReportId(String reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setGenerateDate(LocalDate generateDate) {
            this.generateDate = generateDate;
            return this;
        }

        public Builder setReportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setComputerId(String computerId) {
            this.computerId = computerId;
            return this;
        }

        public Builder copy(Report report) {
            this.reportId = report.reportId;
            this.generateDate = report.generateDate;
            this.reportType = report.reportType;
            this.adminId = report.adminId;
            this.computerId = report.computerId;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}