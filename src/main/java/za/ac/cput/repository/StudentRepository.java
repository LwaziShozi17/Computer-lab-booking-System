package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentId(String studentId);
    Student deleteByStudentId(String studentId);
    List<Student> getAll();
    Optional<Student> findStudentByEmail(String email);
}
