package za.ac.cput.service;

import za.ac.cput.Domain.Verification;
import java.util.List;
import java.util.Optional;

public interface VerificationService {
    Verification create(Verification verification);
    Optional<Verification> read(String id);
    List<Verification> getAll();
    Verification update(Verification verification);
    boolean delete(String id);
}
