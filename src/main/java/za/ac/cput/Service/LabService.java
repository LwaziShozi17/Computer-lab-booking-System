package za.ac.cput.Service;

import za.ac.cput.Domain.Lab;

import java.util.List;

public interface LabService {
    Lab create(Lab lab);
    Lab read(Long id);
    Lab update(Lab lab);
    boolean delete(Long id);
    List<Lab> getAll();
    List<Lab> findByLocation(String location);
    List<Lab> findByCapacityGreaterThanEqual(int capacity);
}
