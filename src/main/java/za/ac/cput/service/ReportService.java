package za.ac.cput.service;

import za.ac.cput.Domain.Report;
import za.ac.cput.Repository.ReportRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    private static ReportService service = null;
    private final ReportRepository repository = ReportRepository.getRepository();

    private ReportService() {}

    public static ReportService getService() {
        if (service == null) {
            service = new ReportService();
        }
        return service;
    }

    // CREATE
    public Report create(Report report) {
        return repository.create(report);
    }

    // READ
    public Report read(String reportId) {
        return repository.read(reportId);
    }

    // UPDATE
    public Report update(Report report) {
        return repository.update(report);
    }

    // DELETE
    public boolean delete(String reportId) {
        return repository.delete(reportId);
    }

    // GET ALL
    public List<Report> getAll() {
        return new ArrayList<>(repository.getAll().values());
    }

    // ADDITIONAL BUSINESS LOGIC
    public List<Report> getReportsByType(String reportType) {
        return getAll().stream()
                .filter(r -> r.getReportType().equalsIgnoreCase(reportType))
                .collect(Collectors.toList());
    }

    public List<Report> getReportsByAdmin(String adminId) {
        return getAll().stream()
                .filter(r -> r.getAdminId().equals(adminId))
                .collect(Collectors.toList());
    }

    public List<Report> getRecentReports(int days) {
        return getAll().stream()
                .filter(r -> r.getGenerateDate()
                        .isAfter(java.time.LocalDate.now().minusDays(days)))
                .collect(Collectors.toList());
    }
}