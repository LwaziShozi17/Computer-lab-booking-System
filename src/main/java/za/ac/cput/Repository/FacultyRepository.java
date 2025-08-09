package za.ac.cput.Repository;
/*
 FacultyRepository class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import za.ac.cput.Domain.Faculty;
import java.util.HashMap;
import java.util.Map;

public class FacultyRepository {
    private static FacultyRepository repository = null;
    private Map<String, Faculty> facultyDB;

    private FacultyRepository() {
        facultyDB = new HashMap<>();
    }

    public static FacultyRepository getRepository() {
        if (repository == null) {
            repository = new FacultyRepository();
        }
        return repository;
    }

    public Faculty create(Faculty faculty) {
        facultyDB.put(faculty.getFacultyId(), faculty);
        return faculty;
    }

    public Faculty read(String facultyId) {
        return facultyDB.get(facultyId);
    }

    public Faculty update(Faculty faculty) {
        facultyDB.replace(faculty.getFacultyId(), faculty);
        return faculty;
    }

    public boolean delete(String facultyId) {
      return facultyDB.remove(facultyId) != null;
    }

    public Map<String, Faculty> getAll() {
        return facultyDB;
    }
}

