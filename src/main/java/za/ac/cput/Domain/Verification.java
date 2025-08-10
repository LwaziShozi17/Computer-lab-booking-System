package za.ac.cput.Domain;

import org.jetbrains.annotations.Contract;

import java.time.LocalDateTime;
public class Verification {
    private final String verificationId;
    private final String userId;
    private final boolean verified;
    private final LocalDateTime verificationDate;

    @Contract(pure = true)
    private Verification(Builder builder) {
        this.verificationId = builder.verificationId;
        this.userId = builder.userId;
        this.verified = builder.verified;
        this.verificationDate = builder.verificationDate;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isVerified() {
        return verified;
    }

    public LocalDateTime getVerificationDate() {
        return verificationDate;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "verificationId='" + verificationId + '\'' +
                ", userId='" + userId + '\'' +
                ", verified=" + verified +
                ", verificationDate=" + verificationDate +
                '}';
    }

    public static class Builder {
        private String verificationId;
        private String userId;
        private boolean verified;
        private LocalDateTime verificationDate;

        public Builder setVerificationId(String verificationId) {
            this.verificationId = verificationId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setVerified(boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder setVerificationDate(LocalDateTime verificationDate) {
            this.verificationDate = verificationDate;
            return this;
        }

        public Builder copy(Verification verification) {
            this.verificationId = verification.verificationId;
            this.userId = verification.userId;
            this.verified = verification.verified;
            this.verificationDate = verification.verificationDate;
            return this;
        }

        public Verification build() {
            return new Verification(this);
        }
    }
}
