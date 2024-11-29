package com.fontys.crowdfund.testBusiness;

import com.fontys.crowdfund.business.impl.UserServiceImpl;
import com.fontys.crowdfund.exception.EmailAlreadyExists;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOUser;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOUser;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private InputDTOUser inputUser;
    private OutputDTOUser outputUser;

    private UserEntity savedUser;
    private String encodedPassword;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Common arrangements for tests
        inputUser = InputDTOUser.builder()
                .email("newuser@example.com")
                .name("New User")
                .password("plaintextpassword")
                .role("user")
                .profilePicture("https://example.com/avatar.png")
                .build();

        encodedPassword = "hashedpassword";

        savedUser = UserEntity.builder()
                .id(1)
                .email(inputUser.getEmail())
                .name(inputUser.getName())
                .password(encodedPassword)
                .projects(new HashSet<>())
                .role(inputUser.getRole())
                .profilePicture(inputUser.getProfilePicture())
                .build();

        outputUser = OutputDTOUser.builder()
                .id(1)
                .email("newuser@example.com")
                .name("New User")
                .role("user")
                .profilePicture("https://example.com/avatar.png")
                .build();
    }

    @Test
    @DisplayName("Should create a new user successfully")
    void createUser_Success() {
        // Arrange
        when(userRepository.existsByEmail(inputUser.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(inputUser.getPassword())).thenReturn(encodedPassword);
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        // Act
        OutputDTOUser result = userService.createUser(inputUser);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("newuser@example.com", result.getEmail());
        assertEquals("New User", result.getName());
        assertEquals("user", result.getRole());
        assertEquals("https://example.com/avatar.png", result.getProfilePicture());
        verify(userRepository, times(1)).existsByEmail(inputUser.getEmail());
        verify(passwordEncoder, times(1)).encode(inputUser.getPassword());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    @DisplayName("Should throw exception when email already exists")
    void createUser_EmailAlreadyExists() {
        // Arrange
        when(userRepository.existsByEmail(inputUser.getEmail())).thenReturn(true);

        // Act & Assert
        assertThrows(EmailAlreadyExists.class, () -> userService.createUser(inputUser));
        verify(userRepository, times(1)).existsByEmail(inputUser.getEmail());
        verify(passwordEncoder, never()).encode(anyString());
        verify(userRepository, never()).save(any(UserEntity.class));
    }

    @Test
    @DisplayName("Should encode password when creating user")
    void createUser_ShouldEncodePassword() {
        // Arrange
        when(userRepository.existsByEmail(inputUser.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(inputUser.getPassword())).thenReturn(encodedPassword);
        when(userRepository.save(any(UserEntity.class))).thenReturn(savedUser);

        // Act
        userService.createUser(inputUser);

        // Assert
        verify(passwordEncoder, times(1)).encode("plaintextpassword");
    }

    @Test
    @DisplayName("Should return a user by Id")
    void get_user_by_id() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(savedUser);

        // Act
        OutputDTOUser u1 = userService.getUserById(1);

        // Assert
        assertEquals(u1.getEmail(), outputUser.getEmail());
    }

    @Test
    @DisplayName("Should delete a user by Id successfully")
    void delete_user_by_id() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(savedUser);
        doNothing().when(userRepository).deleteById(1);

        // Act
        userService.deleteUser(1);

        //Verify
        verify(userRepository, times(1)).deleteById(1);

    }

        @Test
        @DisplayName("Should return all users")
        void get_all_users() {

            List<UserEntity> userRepositoryList = new ArrayList<>();
            userRepositoryList.add(savedUser);

            // Arrange
            when(userRepository.findAll()).thenReturn(userRepositoryList);

            // Act
            List<OutputDTOUser> userList = userService.getAllUsers();

            // Assert
            assertEquals(1, userList.size() );
        }


}
