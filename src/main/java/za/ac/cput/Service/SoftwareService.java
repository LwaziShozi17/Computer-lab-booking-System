package za.ac.cput.Service;

import za.ac.cput.Domain.Software;
import java.util.List;
import java.util.Optional;

public interface SoftwareService {
    Software create(Software software);
    Software read(String id);
    Software update(Software software);
    boolean delete(String id);
    List<Software> getAll();
    List<Software> findByName(String name);
    List<Software> findByVersion(String version);

    Software saveSoftware(Software software);

    List<Software> getAllSoftware();

    List<Software> getSoftwareByName(String intelliJIdea);

    List<Software> getSoftwareByVersion(String s);

    List<Software> getSoftwareByLicenseType(String commercial);

    List<Software> searchSoftwareByName(String intelliJ);

    void deleteSoftware(String s);

    Optional<Software> findSoftwareById(String s);
}
