package com.livraison.notification.service;

import com.livraison.notification.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    Optional<Notification> getNotificationById(Long id);
    List<Notification> getAllNotifications();
    List<Notification> getNotificationsByUserId(Long userId);
}
