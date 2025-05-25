/*   StudentRepository.java
     StudentRepository interface
     Author: SE Sibiya (230975623)
     Date: 25 May 2025 */

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
    List<Student> getAllStudents();
    Optional<Student> findStudentByEmail(String email);
}
