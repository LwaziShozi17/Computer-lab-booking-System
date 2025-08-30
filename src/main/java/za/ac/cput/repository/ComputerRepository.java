package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Computer;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, String> {
    Computer findByComputerId(String computerId);
    List<Computer> findByFaculty(String faculty);
}
