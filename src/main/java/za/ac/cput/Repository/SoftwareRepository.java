package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Software;

import java.util.List;

/* Sithandiwe Ntombela 221805265 */


@Repository
public interface SoftwareRepository extends JpaRepository<Software, String> {

    // Find software by name
    List<Software> findByName(String name);

    // Find software by version
    List<Software> findByVersion(String version);

    // Find software by license type
    List<Software> findByLicenseType(String licenseType);

    // Find software records with a name containing specific text
    List<Software> findByNameContaining(String keyword);
}