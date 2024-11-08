package com.fontys.crowdfund.testBusiness;

import com.fontys.crowdfund.business.impl.UserServiceImpl;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.InputDTOUser;
import com.fontys.crowdfund.persistence.dto.OutputDTOUser;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private static UserEntity user1;
    private static UserEntity user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user1 = UserEntity.builder()
                .id(1)
                .email("user1@example.com")
                .name("User One")
                .password("password1")
                .build();

        user2 = UserEntity.builder()
                .id(2)
                .email("user2@example.com")
                .name("User Two")
                .password("password2")
                .build();
    }

    @Test
    @DisplayName("Should get all users")
    void get_all_users() {
        // Arrange
        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        // Act
        List<OutputDTOUser> users = userService.getAllUsers();

        // Assert
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should add user and return output DTO")
    void add_user() {
        // Arrange
        InputDTOUser inputUser = new InputDTOUser();
        inputUser.setEmail("newuser@example.com");
        inputUser.setName("New User");
        inputUser.setPassword("newpassword");

        UserEntity savedUser = UserEntity.builder()
                .id(3)
                .email("newuser@example.com")
                .name("New User")
                .password("newpassword")
                .build();

        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        // Act
        OutputDTOUser result = userService.createUser(inputUser);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.getId());
        assertEquals("newuser@example.com", result.getEmail());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    @DisplayName("Should get user by ID")
    void get_user_by_id() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(user1);

        // Act
        OutputDTOUser user = userService.getUserById(1);

        // Assert
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("user1@example.com", user.getEmail());
        verify(userRepository, times(1)).findById(1);
    }


    @Test
    @DisplayName("Should delete user by ID")
    void delete_user_by_id() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(user1);
        doNothing().when(userRepository).deleteById(1);

        // Act
        userService.deleteUser(1);

        // Assert
        verify(userRepository, times(1)).deleteById(1);
    }

    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should throw exception if user to delete not found")
    void delete_user_by_id_not_found() {
        // Arrange
        when(userRepository.findById(99)).thenReturn(null);

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> userService.deleteUser(99));
        assertEquals("User not found", thrown.getMessage());
        verify(userRepository, times(1)).findById(99);
        verify(userRepository, never()).deleteById(99);
    }

    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should throw exception if user not found by ID")
    void get_user_by_id_not_found() {
        // Arrange
        when(userRepository.findById(99)).thenReturn(null);

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> userService.getUserById(99));
        assertEquals("User not found", thrown.getMessage());
        verify(userRepository, times(1)).findById(99);
    }

}
