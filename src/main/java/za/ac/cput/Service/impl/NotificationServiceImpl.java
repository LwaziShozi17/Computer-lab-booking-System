package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Notification;
import za.ac.cput.Repository.NotificationRepository;
import za.ac.cput.Service.NotificationService;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public boolean delete(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> findByRecipientType(String recipientType) {
        return notificationRepository.findByRecipientType(recipientType);
    }

    @Override
    public List<Notification> findByRecipientId(Long recipientId) {
        return notificationRepository.findByRecipientId(recipientId);
    }
}
