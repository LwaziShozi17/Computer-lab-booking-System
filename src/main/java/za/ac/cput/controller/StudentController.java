/*   StudentController.java
     StudentController class
     Author: SE Sibiya (230975623)
     Date: 08 August 2025 2025 */

package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student.com")
public class StudentController {
    private final StudentService studentService;

   // @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = studentService.saveStudent(student);
            return ResponseEntity.ok(Map.of("studentId", registeredStudent));
        } catch (RuntimeException e) {
            System.out.println("Student already registered");
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/read")
    public  ResponseEntity<?> readStudent(@RequestBody Student student) {
        try {
            Student foundStudent = studentService.readStudent(student.getStudentId());
            return ResponseEntity.ok(Map.of("student", foundStudent));
        } catch (RuntimeException e) {
            System.out.println("Student was not found");
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(
            @RequestParam("studentId") String studentId) {
        try {
            Student student = studentService.findByStudentId(studentId);
            if (student == null) {
                throw new RuntimeException("Student not found for update");
            }
            // Update the student information as needed
            student = new Student.Builder()
                    .copy(student)
                    .setLastName("Sibaya")
                    .setFaculty("Informatic and Design")
                    .build();
            Student updatedStudent = studentService.updateStudent(student);

            return ResponseEntity.ok(Map.of("student", updatedStudent));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}
