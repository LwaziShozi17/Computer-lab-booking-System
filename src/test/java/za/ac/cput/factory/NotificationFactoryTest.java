package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Notification;
import za.ac.cput.Factory.NotificationFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void createNotification() {
        LocalDateTime now = LocalDateTime.now();
        Notification notification = NotificationFactory.createNotification(
                1L, "Your booking is confirmed", now, "Student", 1001L
        );
        
        assertNotNull(notification);
        assertEquals(1L, notification.getNotificationId());
        assertEquals("Your booking is confirmed", notification.getMessage());
        assertEquals(now, notification.getSentAt());
        assertEquals("Student", notification.getRecipientType());
        assertEquals(1001L, notification.getRecipientId());
    }

    @Test
    void createNotificationWithNullValues() {
        Notification notification = NotificationFactory.createNotification(
                null, null, null, null, null
        );
        
        assertNull(notification);
    }
}
