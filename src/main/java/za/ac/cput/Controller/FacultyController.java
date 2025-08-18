package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Faculty;
import za.ac.cput.Service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/create")
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.create(faculty);
        return new ResponseEntity<>(createdFaculty, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Faculty> read(@PathVariable String id) {
        Faculty faculty = facultyService.read(id);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.update(faculty);
        if (updatedFaculty != null) {
            return new ResponseEntity<>(updatedFaculty, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = facultyService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Faculty>> getAll() {
        List<Faculty> faculties = facultyService.getAll();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @GetMapping("/findByFacultyName/{facultyName}")
    public ResponseEntity<List<Faculty>> findByFacultyName(@PathVariable String facultyName) {
        List<Faculty> faculties = facultyService.findByFacultyName(facultyName);
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
}
