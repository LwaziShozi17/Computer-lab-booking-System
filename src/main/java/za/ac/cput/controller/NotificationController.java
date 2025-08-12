package za.ac.cput.controller;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Notification;
import za.ac.cput.services.LabService;
import za.ac.cput.services.NotificationService;

import java.util.List;
import java.util.Optional;

public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service){
        this.service = service;
    }

    public Notification sendNotification(Notification notification){
        return service.send(notification);
    }

    public Optional<Notification> getNotification(Long id){
        return service.get(id);
    }

    public List<Notification> getNotificationsForRecipient(String recipientType, Long recipientId){
        return service.findByRecipient(recipientType, recipientId);
    }

    public void deleteNotification(Long id){
        service.delete(id);
    }
}
