/*   StudentService.java
     StudentService class
     Author: SE Sibiya (230975623)
     Date: 08 August 2025 2025 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudent {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (studentRepository.findByStudentId(student.getStudentId()) != null) {
            throw new RuntimeException("Student already registered");
        }
        // Save the student if not already registered
        return this.studentRepository.save(student);
    }

    @Override
    public Student read(String s) {
        if (studentRepository.findByStudentId(s) == null) {
            throw new RuntimeException("Student not found");
        }
        System.out.println("Student found: ");
        return this.studentRepository.findByStudentId(s);
    }

    @Override
    public Student update(Student student) {
        if (studentRepository.findByStudentId(student.getStudentId()) == null) {
            throw new RuntimeException("Student not found for update");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student delete(String s) {
        Student student = studentRepository.findByStudentId(s);
        if (student == null) {
            throw new RuntimeException("Student not found for deletion");
        }
        studentRepository.delete(student);
        return student;
    }


    @Override
    public List<Student> findAllStudent() {
        return this.studentRepository.findAll();
    }

    // Method to find student by studentId
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }


}
