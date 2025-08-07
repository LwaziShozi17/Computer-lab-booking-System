/*   StudentService.java
     StudentService class
     Author: SE Sibiya (230975623)
     Date: 08 August 2025 2025 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Method to check if student exists in database and register if not
    public Student saveStudent(Student student) {
        if (studentRepository.findByStudentId(student.getStudentId()) != null) {
            throw new RuntimeException("Student already registered");
        }
        // Save the student infovif not already registered
        return studentRepository.save(student);
    }

    // Method to find student by studentId
    public Student readStudent(String studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        System.out.println("Student found: " + student.getFirstName());
        return student;
    }

    // Method to update student information
    public Student updateStudent(Student student) {
        if (studentRepository.findByStudentId(student.getStudentId()) == null) {
            throw new RuntimeException("Student not found for update");
        }
        return studentRepository.save(student);
    }

    // Method to find student by studentId
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

}
