package za.ac.cput.Service;

import za.ac.cput.Domain.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty create(Faculty faculty);
    Faculty read(String id);
    Faculty update(Faculty faculty);
    boolean delete(String id);
    List<Faculty> getAll();
    List<Faculty> findByFacultyName(String facultyName);
}
