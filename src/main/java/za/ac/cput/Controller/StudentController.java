package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Student;
import za.ac.cput.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student createdStudent = studentService.create(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id) {
        Student student = studentService.read(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student updatedStudent = studentService.update(student);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = studentService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/findByFaculty/{faculty}")
    public ResponseEntity<List<Student>> findByFaculty(@PathVariable String faculty) {
        List<Student> students = studentService.findByFaculty(faculty);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/findByCurrentYear/{currentYear}")
    public ResponseEntity<List<Student>> findByCurrentYear(@PathVariable String currentYear) {
        List<Student> students = studentService.findByCurrentYear(currentYear);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
