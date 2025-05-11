package za.ac.cput.Domain;

import java.time.LocalDateTime;


public class Notification {


    private Long notificationId;

    private String message;

    private LocalDateTime sentAt;

    private String recipientType; // Example: "Student", "Admin"

    private Long recipientId;

    // Constructors
    public Notification() {}

    public Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.message = builder.message;
        this.sentAt = builder.sentAt;
        this.recipientType = builder.recipientType;
        this.recipientId = builder.recipientId;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public class Builder{
        private Long notificationId;

        private String message;

        private LocalDateTime sentAt;

        private String recipientType; // Example: "Student", "Admin"

        private Long recipientId;

        public Builder setNotificationId(Long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setSentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public Builder setRecipientType(String recipientType) {
            this.recipientType = recipientType;
            return this;
        }

        public Builder setRecipientId(Long recipientId) {
            this.recipientId = recipientId;
            return this;
        }

        public Builder copy(Notification notification) {
            this.notificationId = notification.notificationId;
            this.message = notification.message;
            this.sentAt = notification.sentAt;
            this.recipientType = notification.recipientType;
            this.recipientId = notification.recipientId;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
