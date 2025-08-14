package za.ac.cput.Service;

import za.ac.cput.Domain.Software;
import java.util.List;

public interface SoftwareService {
    Software create(Software software);
    Software read(String id);
    Software update(Software software);
    boolean delete(String id);
    List<Software> getAll();
    List<Software> findByName(String name);
    List<Software> findByVersion(String version);
}
