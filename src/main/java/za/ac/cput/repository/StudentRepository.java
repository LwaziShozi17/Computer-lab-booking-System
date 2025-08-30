/*   StudentRepository.java
     StudentRepository interface
     Author: SE Sibiya (230975623)
     Date: 08 August 2025 2025 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(Long studentId);
    Student findByEmail(String email);
//    Student deleteByStudentId(String studentId);
//    List<Student> getAllStudents();
//    Optional<Student> findStudentByEmail(String email);
}
