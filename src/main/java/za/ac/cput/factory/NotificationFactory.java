package za.ac.cput.factory;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Notification;
import java.time.LocalDateTime;

public class NotificationFactory {
    public static Notification createNotification(Long id, String message, LocalDateTime sentAt, String recipientType, Long recipientId){
        if(message == null || message.trim().isEmpty()){
            throw new IllegalArgumentException("Message is required");
        }
        if(recipientType == null || recipientType.trim().isEmpty()){
            throw new IllegalArgumentException("Recipient type is required");
        }
        if(sentAt == null) sentAt = LocalDateTime.now();

        return new Notification().new Builder()
                .setNotificationId(id)
                .setMessage(message)
                .setSentAt(sentAt)
                .setRecipientType(recipientType)
                .setRecipientId(recipientId)
                .build();
    }
}