package za.ac.cput.factory;

import za.ac.cput.Domain.Report;
import java.time.LocalDate;


public class ReportFactory {
    public static Report createReport(String reportId, String reportType,
                                      String adminId, String computerId) {
        return new Report.Builder()
                .setReportId(reportId)
                .setGenerateDate(LocalDate.now())  // Auto-sets to current date
                .setReportType(reportType)
                .setAdminId(adminId)
                .setComputerId(computerId)
                .build();
    }

    public static Report createReport(String reportType, String adminId,
                                      String computerId) {
        String generatedId = generateReportId();
        return createReport(generatedId, reportType, adminId, computerId);
    }

    private static String generateReportId() {
        return "RPT-" + System.currentTimeMillis();
    }
}