package za.ac.cput.controller;

/*
 FacultyController class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.service.FacultyService;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/faculty.com")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping("/faculty")
    public ResponseEntity<?> readFaculty(@RequestBody Faculty faculty) {
        try {
            Faculty foundFaculty = facultyService.read(faculty.getFacultyId());
            return ResponseEntity.ok(Map.of("faculty", foundFaculty));
        } catch (RuntimeException e) {
            System.out.println("Faculty was not found");
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    @PostMapping("/faculty")
    public ResponseEntity<?> updateFaculty(
            @RequestParam("facultyId") String facultyId) {
        try {
            Faculty faculty = facultyService.read(facultyId);
            if (faculty == null) {
                throw new RuntimeException("Faculty not found for update");
            }
            // Update the faculty information as needed
            faculty = new Faculty.Builder()
                    .copy(faculty)
                    .setFacultyName("Informatic and Design")
                    .build();
            Faculty updatedFaculty = facultyService.update(faculty);

            return ResponseEntity.ok(Map.of("faculty", updatedFaculty));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/all")
    public ResponseEntity<?> getAllFaculties() {
        try {
            return ResponseEntity.ok(Map.of("faculties", facultyService.getAll()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
