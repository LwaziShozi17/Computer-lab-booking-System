package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Verification;
import za.ac.cput.Repository.VerificationRepository;
import za.ac.cput.service.VerificationService;

import java.util.List;
import java.util.Optional;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationRepository verificationRepository;

    public VerificationServiceImpl(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    @Override
    public Verification create(Verification verification) {
        return verificationRepository.create(verification);
    }

    @Override
    public Optional<Verification> read(String id) {
        return Optional.ofNullable(verificationRepository.read(id));
    }

    @Override
    public List<Verification> getAll() {
        return verificationRepository.getAll();
    }

    @Override
    public Verification update(Verification verification) {
        return verificationRepository.update(verification);
    }

    @Override
    public boolean delete(String id) {
        return verificationRepository.delete(id);
    }
}
