package za.ac.cput.Repository;

import za.ac.cput.Domain.Report;
import java.util.HashMap;
import java.util.Map;


public class ReportRepository {
    private static ReportRepository repository = null;
    private final Map<String, Report> reportDB; // Marked as final

    private ReportRepository() {
        reportDB = new HashMap<>();
    }

    public static ReportRepository getRepository() {
        if (repository == null) {
            repository = new ReportRepository();
        }
        return repository;
    }

    public Report create(Report report) {
        reportDB.put(report.getReportId(), report);
        return report;
    }

    public Report read(String reportId) {
        return reportDB.get(reportId);
    }

    public Report update(Report report) {
        if (reportDB.containsKey(report.getReportId())) {
            reportDB.put(report.getReportId(), report);
            return report;
        }
        return null;
    }

    public boolean delete(String reportId) {
        return reportDB.remove(reportId) != null;
    }

    public Map<String, Report> getAll() {
        return new HashMap<>(reportDB);
    }
}