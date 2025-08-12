package za.ac.cput.Factory;

/* Sithandiwe Ntombela 221805265 */


import za.ac.cput.Domain.Maintenance;

public class MaintenanceFactory {

    public static Maintenance createMaintenance(String maintenanceId, String softwareId, String date, String description) {
        return new Maintenance.Builder()
                .setMaintenanceId(maintenanceId)
                .setSoftwareId(softwareId)
                .setDate(date)
                .setDescription(description)
                .build();
    }
}