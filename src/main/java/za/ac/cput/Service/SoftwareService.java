package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Software;
import za.ac.cput.Repository.SoftwareRepository;

/* Sithandiwe Ntombela 221805265 */


import java.util.List;
import java.util.Optional;

@Service
public class SoftwareService {

    @Autowired
    private SoftwareRepository softwareRepository;

    // Create or Update Software
    public Software saveSoftware(Software software) {
        return softwareRepository.save(software);
    }

    // Read Software by ID
    public Optional<Software> findSoftwareById(String id) {
        return softwareRepository.findById(id);
    }

    // Get All Software Records
    public List<Software> getAllSoftware() {
        return softwareRepository.findAll();
    }

    // Delete Software by ID
    public void deleteSoftware(String id) {
        softwareRepository.deleteById(id);
    }

    // Find Software by Name
    public List<Software> getSoftwareByName(String name) {
        return softwareRepository.findByName(name);
    }

    // Find Software by Version
    public List<Software> getSoftwareByVersion(String version) {
        return softwareRepository.findByVersion(version);
    }

    // Find Software by License Type
    public List<Software> getSoftwareByLicenseType(String licenseType) {
        return softwareRepository.findByLicenseType(licenseType);
    }

    // Search Software by Name
    public List<Software> searchSoftwareByName(String keyword) {
        return softwareRepository.findByNameContaining(keyword);
    }
}