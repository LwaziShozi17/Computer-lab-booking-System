package za.ac.cput.repository;

//Thuso Siduka 220041776

import za.ac.cput.Domain.Notification;
import java.util.*;

public class NotificationRepository {
    private static NotificationRepository repository = null;
    private final Map<Long, Notification> notificationDB;

    private NotificationRepository(){
        this.notificationDB = new HashMap<>();
    }

    public static NotificationRepository getRepository(){
        if(repository == null){
            repository = new NotificationRepository();
        }
        return repository;
    }

    public Notification create(Notification notification){
        this.notificationDB.put(notification.getNotificationId(), notification);
        return notification;
    }

    public Notification read(Long notificationId){
        return this.notificationDB.get(notificationId);
    }

    public Notification update(Notification notification){
        if(this.notificationDB.containsKey(notification.getNotificationId())){
            this.notificationDB.put(notification.getNotificationId(), notification);
            return notification;
        }
        return null;
    }

    public boolean delete(Long notificationId){
        return this.notificationDB.remove(notificationId) != null;
    }

    public Set<Notification> getAll(){
        return new HashSet<>(this.notificationDB.values());
    }
}
