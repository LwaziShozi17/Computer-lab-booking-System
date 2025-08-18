package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Notification;
import za.ac.cput.Service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Notification> create(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.create(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Notification> read(@PathVariable Long id) {
        Notification notification = notificationService.read(id);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Notification> update(@RequestBody Notification notification) {
        Notification updatedNotification = notificationService.update(notification);
        return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = notificationService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Notification>> getAll() {
        List<Notification> notifications = notificationService.getAll();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/findByRecipientType/{recipientType}")
    public ResponseEntity<List<Notification>> findByRecipientType(@PathVariable String recipientType) {
        List<Notification> notifications = notificationService.findByRecipientType(recipientType);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/findByRecipientId/{recipientId}")
    public ResponseEntity<List<Notification>> findByRecipientId(@PathVariable Long recipientId) {
        List<Notification> notifications = notificationService.findByRecipientId(recipientId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
