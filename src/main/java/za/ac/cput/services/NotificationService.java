package za.ac.cput.services;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Notification;
import za.ac.cput.Util.Helper;

import java.util.*;

public class NotificationService {
    private final Map<Long, Notification> notificationStore = new HashMap<>();

    public Notification send(Notification notification){
        Long id = notification.getNotificationId() == null ? Helper.generateId() : notification.getNotificationId();
        Notification built = new Notification().new Builder().copy(notification).setNotificationId(id).build();
        notificationStore.put(id, built);
        // In real app: push to messaging/email system. Here we just store.
        return built;
    }

    public Optional<Notification> get(Long id){
        return Optional.ofNullable(notificationStore.get(id));
    }

    public List<Notification> findByRecipient(String recipientType, Long recipientId){
        List<Notification> out = new ArrayList<>();
        for(Notification n : notificationStore.values()){
            if(n.getRecipientType().equalsIgnoreCase(recipientType) && Objects.equals(n.getRecipientId(), recipientId)){
                out.add(n);
            }
        }
        return out;
    }

    public void delete(Long id){
        notificationStore.remove(id);
    }

    public List<Notification> findAll(){
        return new ArrayList<>(notificationStore.values());
    }
}
