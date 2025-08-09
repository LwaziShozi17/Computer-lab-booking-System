package za.ac.cput.service;

/*
 FacultyService class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.Repository.FacultyRepository;

import java.util.Map;
import java.util.Objects;

@Service
public class FacultyService {
    private final FacultyRepository repository;

    @Autowired
    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    public Faculty save(Faculty faculty) {
        validateFaculty(faculty);
        checkDuplicateFaculty(faculty);
        checkFacultyNameUniqueness(faculty);
        return repository.create(faculty);
    }

    public Faculty read(String facultyId) {
        Faculty faculty = repository.read(facultyId);
        if (faculty == null) {
            throw new RuntimeException("Faculty with ID " + facultyId + " not found");
        }
        return faculty;
    }

    public Faculty update(Faculty faculty) {
        if (repository.read(faculty.getFacultyId()) == null) {
            throw new RuntimeException("Faculty not found for update");
        }
        checkFacultyNameUniqueness(faculty);
        return repository.update(faculty);
    }

    public boolean delete(String facultyId) {
        if (repository.read(facultyId) == null) {
            throw new RuntimeException("Faculty not found for deletion");
        }
        return repository.delete(facultyId);
    }

    public Map<String, Faculty> getAll() {
        return repository.getAll();
    }

    public boolean facultyNameExists(String facultyName) {
        return repository.getAll().values().stream()
                .anyMatch(f -> f.getFacultyName().equalsIgnoreCase(facultyName));
    }

    private void validateFaculty(Faculty faculty) {
        if (faculty == null ||
                Objects.isNull(faculty.getFacultyId()) ||
                faculty.getFacultyId().isBlank() ||
                Objects.isNull(faculty.getFacultyName()) ||
                faculty.getFacultyName().isBlank()) {
            throw new IllegalArgumentException("Faculty is invalid or incomplete");
        }
    }

    private void checkDuplicateFaculty(Faculty faculty) {
        if (repository.read(faculty.getFacultyId()) != null) {
            throw new RuntimeException("Faculty ID " + faculty.getFacultyId() + " already exists");
        }
    }

    private void checkFacultyNameUniqueness(Faculty faculty) {
        if (facultyNameExists(faculty.getFacultyName())) {
            throw new RuntimeException("Faculty name '" + faculty.getFacultyName() + "' already exists");
        }
    }
}