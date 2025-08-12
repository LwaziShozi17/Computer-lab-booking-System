package za.ac.cput.controller;

import za.ac.cput.Domain.Report;
import za.ac.cput.service.ReportService;
import java.util.List;

public class ReportController {
    private final ReportService reportService = ReportService.getService();

    // Create a new report
    public Report createReport(String reportId, String reportType, String adminId, String computerId) {
        Report report = new Report.Builder()
                .setReportId(reportId)
                .setReportType(reportType)
                .setAdminId(adminId)
                .setComputerId(computerId)
                .build();
        return reportService.create(report);
    }

    // Read a report by ID
    public Report readReport(String reportId) {
        return reportService.read(reportId);
    }

    // Update a report
    public Report updateReport(Report report) {
        return reportService.update(report);
    }

    // Delete a report
    public boolean deleteReport(String reportId) {
        return reportService.delete(reportId);
    }

    // Get all reports
    public List<Report> getAllReports() {
        return reportService.getAll();
    }

    // Additional methods as needed...
}