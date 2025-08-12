package za.ac.cput.util;

import za.ac.cput.Domain.Software;
import za.ac.cput.Domain.Maintenance;
import java.util.UUID;

public class Helper {

    // Generate a unique ID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }


    // Check for null/empty strings
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Validate Software object
    public static boolean isSoftwareValid(Software software) {
        return software != null &&
                !isNullOrEmpty(software.getSoftwareId()) &&
                !isNullOrEmpty(software.getName()) &&
                !isNullOrEmpty(software.getVersion()) &&
                !isNullOrEmpty(software.getLicenseType());
    }

    // Validate Maintenance object
    public static boolean isMaintenanceValid(Maintenance maintenance) {
        return maintenance != null &&
                !isNullOrEmpty(maintenance.getMaintenanceId()) &&
                !isNullOrEmpty(maintenance.getSoftwareId()) &&
                !isNullOrEmpty(maintenance.getDate()) &&
                !isNullOrEmpty(maintenance.getDescription());
    }
}