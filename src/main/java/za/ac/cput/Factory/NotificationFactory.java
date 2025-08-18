package za.ac.cput.Factory;

import za.ac.cput.Domain.Notification;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class NotificationFactory {
    public static Notification createNotification(Long notificationId, String message, 
                                               LocalDateTime sentAt, String recipientType, 
                                               Long recipientId) {
        if (Helper.isNullOrEmpty(String.valueOf(notificationId)) || 
            Helper.isNullOrEmpty(message) || 
            sentAt == null || 
            Helper.isNullOrEmpty(recipientType) || 
            Helper.isNullOrEmpty(String.valueOf(recipientId))) {
            return null;
        }
        
        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setMessage(message)
                .setSentAt(sentAt)
                .setRecipientType(recipientType)
                .setRecipientId(recipientId)
                .build();
    }
}
