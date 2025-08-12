package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Verification;

import static org.junit.jupiter.api.Assertions.*;

class VerificationFactoryTest {

    @Test
    void createVerification_success() {
        Verification verification = VerificationFactory.createVerification("USER123", true);

        assertNotNull(verification);
        assertNotNull(verification.getVerificationId());
        assertEquals("USER123", verification.getUserId());
        assertTrue(verification.isVerified());
        assertNotNull(verification.getVerificationDate());
    }

    @Test
    void createVerification_fail_missingUserId() {
        Verification verification = VerificationFactory.createVerification("", true);
        assertNull(verification); // Expect null for invalid userId
    }
}
