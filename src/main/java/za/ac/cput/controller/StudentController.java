/*   StudentController.java
     StudentController class
     Author: SE Sibiya (230975623)
     Date: 08 August 2025 2025 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/http/cputlibrary.com")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/SignUp")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = studentService.create(student);
            return ResponseEntity.ok(Map.of("studentId", registeredStudent));
        } catch (RuntimeException e) {
            System.out.println("Student already registered" + e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        try {
            Student student = studentService.validateUserLogIn(email, password);
            return ResponseEntity.ok(Map.of(
                    "studentId", student.getStudentId(),
                    "firstName", student.getFirstName(),
                    "lastName", student.getLastName(),
                    "faculty", student.getFaculty(),
                    "enrollmentYear", student.getEnrollmentYear(),
                    "currentYear", student.getCurrentYear(),
                    "email", student.getEmail()));
        } catch (RuntimeException e) {
            System.out.println("Login failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}
