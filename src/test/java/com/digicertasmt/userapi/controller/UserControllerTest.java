package com.digicertasmt.userapi.controller;

import com.digicertasmt.userapi.model.User;
import com.digicertasmt.userapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));

        // Perform the test
        List<User> result = userController.getAllUsers();

        // Verify interactions
        verify(userRepository, times(1)).findAll();

        // Assert the result
        assertEquals(2, result.size());
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Perform the test
        User result = userController.getUserById(1L);

        // Verify interactions
        verify(userRepository, times(1)).findById(1L);

        // Assert the result
        assertEquals(1L, result.getId());
    }

    @Test
    void testCreateUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // Perform the test
        User result = userController.createUser(user);

        // Verify interactions
        verify(userRepository, times(1)).save(user);

        // Assert the result
        assertEquals(user, result);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        // Perform the test
        User result = userController.updateUser(1L, user);

        // Verify interactions
        verify(userRepository, times(1)).save(user);

        // Assert the result
        assertEquals(1L, result.getId());
    }

    @Test
    void testDeleteUser() {
        // Perform the test
        userController.deleteUser(1L);

        // Verify interactions
        verify(userRepository, times(1)).deleteById(1L);
    }
}

