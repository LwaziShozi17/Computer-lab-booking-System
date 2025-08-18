package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Faculty;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
    List<Faculty> findByFacultyName(String facultyName);
}
