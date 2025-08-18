package za.ac.cput.Service;

import za.ac.cput.Domain.Notification;

import java.util.List;

public interface NotificationService {
    Notification create(Notification notification);
    Notification read(Long id);
    Notification update(Notification notification);
    boolean delete(Long id);
    List<Notification> getAll();
    List<Notification> findByRecipientType(String recipientType);
    List<Notification> findByRecipientId(Long recipientId);
}
