package za.ac.cput.Service;

import za.ac.cput.Domain.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student read(String id);
    Student update(Student student);
    boolean delete(String id);
    List<Student> getAll();
    List<Student> findByFaculty(String faculty);
    List<Student> findByCurrentYear(String currentYear);
}
