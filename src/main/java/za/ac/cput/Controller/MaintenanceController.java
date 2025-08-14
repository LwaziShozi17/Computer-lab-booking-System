package za.ac.cput.Controller;

import za.ac.cput.Domain.Maintenance;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* Sithandiwe Ntombela 221805265 */


public class MaintenanceController {
    private final List<Maintenance> maintenanceRecords;

    public MaintenanceController() {
        this.maintenanceRecords = new ArrayList<>();
    }

    // Create a new Maintenance record
    public void addMaintenance(Maintenance maintenance) {
        maintenanceRecords.add(maintenance);
    }

    // Read all Maintenance records
    public List<Maintenance> getAllMaintenance() {
        return new ArrayList<>(maintenanceRecords);
    }

    // Find a Maintenance record by ID
    public Optional<Maintenance> getMaintenanceById(String maintenanceId) {
        return maintenanceRecords.stream()
                .filter(maintenance -> maintenance.getMaintenanceId().equals(maintenanceId))
                .findFirst();
    }

    // Update a Maintenance record
    public void updateMaintenance(String maintenanceId, Maintenance updatedMaintenance) {
        Optional<Maintenance> existingMaintenance = getMaintenanceById(maintenanceId);
        existingMaintenance.ifPresent(maintenance -> {
            maintenanceRecords.remove(maintenance);
            maintenanceRecords.add(updatedMaintenance);
        });
    }

    // Delete a Maintenance record
    public void deleteMaintenance(String maintenanceId) {
        maintenanceRecords.removeIf(maintenance -> maintenance.getMaintenanceId().equals(maintenanceId));
    }
}