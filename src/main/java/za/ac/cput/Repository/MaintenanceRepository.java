package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Maintenance;


/* Sithandiwe Ntombela 221805265 */


import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {

    // Find all maintenance records for a specific software
    List<Maintenance> findBySoftwareId(String softwareId);

    // Find maintenance by date
    List<Maintenance> findByDate(String date);

    // Find maintenance records with a description containing specific text
    List<Maintenance> findByDescriptionContaining(String keyword);
}