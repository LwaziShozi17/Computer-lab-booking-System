package za.ac.cput.factory;

import za.ac.cput.Domain.Verification;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class VerificationFactory {

    public static Verification createVerification(String userId, boolean verified) {
        if (Helper.isNullOrEmpty(userId)) {
            return null;
        }
        return new Verification.Builder()
                .setVerificationId(Helper.generateId())
                .setUserId(userId)
                .setVerified(verified)
                .setVerificationDate(LocalDateTime.now())
                .build();
    }
}
