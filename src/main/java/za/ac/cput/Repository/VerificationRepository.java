package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Verification;

import java.util.List;
import java.util.Map;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, String> {
    Verification create(Verification verification);
    Verification read(String id);
    List<Verification> getAll();
    Verification update(Verification verification);
    boolean delete(String id);
}
