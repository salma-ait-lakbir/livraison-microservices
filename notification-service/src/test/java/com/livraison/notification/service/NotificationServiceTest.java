package com.livraison.notification.service;

import com.livraison.notification.entity.Notification;
import com.livraison.notification.repository.NotificationRepository;
import com.livraison.notification.service.impl.NotificationServiceImpl;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    void testSaveNotification() {
        NotificationRepository repository = mock(NotificationRepository.class);
        NotificationService service = new NotificationServiceImpl(repository); // ✔️ depuis impl

        Notification notification = new Notification();
        notification.setMessage("Message test");
        notification.setUserId(1L);

        when(repository.save(notification)).thenReturn(notification);

        Notification saved = service.saveNotification(notification);

        assertNotNull(saved);
        assertEquals("Message test", saved.getMessage());
    }
}
