package za.ac.cput.Repository;

import za.ac.cput.Domain.Verification;
import java.util.HashMap;
import java.util.Map;

public class VerificationRepository {
    private static VerificationRepository repository = null;
    private Map<String, Verification> verificationDB;

    private VerificationRepository() {
        verificationDB = new HashMap<>();
    }

    public static VerificationRepository getRepository() {
        if (repository == null) {
            repository = new VerificationRepository();
        }
        return repository;
    }

    public Verification create(Verification verification) {
        verificationDB.put(verification.getVerificationId(), verification);
        return verification;
    }

    public Verification read(String verificationId) {
        return verificationDB.get(verificationId);
    }

    public Verification update(Verification verification) {
        if (verificationDB.containsKey(verification.getVerificationId())) {
            verificationDB.put(verification.getVerificationId(), verification);
            return verification;
        }
        return null;
    }

    public boolean delete(String verificationId) {
        return verificationDB.remove(verificationId) != null;
    }
}
