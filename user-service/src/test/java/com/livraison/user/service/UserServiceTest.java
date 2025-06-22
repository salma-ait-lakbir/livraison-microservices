package com.livraison.user.service;

import com.livraison.user.entity.User;
import com.livraison.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    void testFindByEmail() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        User user = new User();
        user.setEmail("ali@example.com");

        when(userRepository.findByEmail("ali@example.com")).thenReturn(Optional.of(user));

        User found = userService.findByEmail("ali@example.com");

        assertNotNull(found);
        assertEquals("ali@example.com", found.getEmail());
    }
}