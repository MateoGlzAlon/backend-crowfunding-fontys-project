package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOUser;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOUser;
import com.fontys.crowdfund.persistence.specialdto.UserProjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserControllerImpl userController;

    @Mock
    private UserService userService;

    private OutputDTOUser testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = OutputDTOUser.builder()
                .id(1)
                .name("John Doe")
                .email("john.doe@example.com")
                .role("USER")
                .profilePicture("profile.jpg")
                .build();
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<OutputDTOUser> users = Arrays.asList(testUser);
        when(userService.getAllUsers()).thenReturn(users);

        // Act
        List<OutputDTOUser> result = userController.getAllUsers();

        // Assert
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Arrange
        when(userService.getUserById(1)).thenReturn(testUser);

        // Act
        ResponseEntity<OutputDTOUser> response = userController.getUserById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getName());
        verify(userService, times(1)).getUserById(1);
    }

    @Test
    void testGetUserDataForProject() {
        // Arrange
        UserProjectDTO projectDTO = new UserProjectDTO("name", "urlexample");
        when(userService.getUserDataForProject(1)).thenReturn(projectDTO);

        // Act
        ResponseEntity<UserProjectDTO> response = userController.getUserDataForProject(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("name", response.getBody().getName());
        verify(userService, times(1)).getUserDataForProject(1);
    }

    @Test
    void testGetUserIdFromEmail() {
        // Arrange
        String email = "john.doe@example.com";
        when(userService.getUserIdFromEmail(email)).thenReturn(1);

        // Act
        ResponseEntity<Integer> response = userController.getUserIdFromEmail(email);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody());
        verify(userService, times(1)).getUserIdFromEmail(email);
    }

    @Test
    void testCreateUser() {
        // Arrange
        InputDTOUser inputDTOUser = new InputDTOUser("John Doe", "john.doe@example.com", "password123", "USER", "profile.jpg");
        when(userService.createUser(inputDTOUser)).thenReturn(testUser);

        // Act
        ResponseEntity<OutputDTOUser> response = userController.createUser(inputDTOUser);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getName());
        verify(userService, times(1)).createUser(inputDTOUser);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        doNothing().when(userService).deleteUser(1);

        // Act
        ResponseEntity<Void> response = userController.deleteUser(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(userService, times(1)).deleteUser(1);
    }
}
