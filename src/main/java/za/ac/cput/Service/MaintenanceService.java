package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Maintenance;
import za.ac.cput.Repository.MaintenanceRepository;

/* Sithandiwe Ntombela 221805265 */


import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    // Create or Update Maintenance
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    // Read Maintenance by ID
    public Optional<Maintenance> findMaintenanceById(String id) {
        return maintenanceRepository.findById(id);
    }

    // Get All Maintenance Records
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    // Delete Maintenance by ID
    public void deleteMaintenance(String id) {
        maintenanceRepository.deleteById(id);
    }

    // Find Maintenance by Software ID
    public List<Maintenance> getMaintenanceBySoftwareId(String softwareId) {
        return maintenanceRepository.findBySoftwareId(softwareId);
    }

    // Find Maintenance by Date
    public List<Maintenance> getMaintenanceByDate(String date) {
        return maintenanceRepository.findByDate(date);
    }

    // Search Maintenance by Description
    public List<Maintenance> searchMaintenanceByDescription(String keyword) {
        return maintenanceRepository.findByDescriptionContaining(keyword);
    }
}