package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.InputDTOUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputDTOUserTest {

    private InputDTOUser testUserDTO;

    @BeforeEach
    void setUp() {
        // Initialize testUserDTO
        testUserDTO = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testUserDTONotNull() {
        // Check if testUserDTO is not null
        assertNotNull(testUserDTO, "Test UserDTO should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that an InputDTOUser can be created using no-args constructor
        InputDTOUser userDTO = new InputDTOUser();
        assertNotNull(userDTO, "InputDTOUser created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an InputDTOUser can be created with all args constructor
        InputDTOUser userDTO = new InputDTOUser("Jane Doe", "jane.doe@example.com", "password123");
        assertNotNull(userDTO, "InputDTOUser created with all-args constructor should not be null");
        assertEquals("Jane Doe", userDTO.getName(), "User name should be 'Jane Doe'");
    }

    @Test
    void testBuilder() {
        // Ensure that an InputDTOUser can be created using the builder
        InputDTOUser userDTO = InputDTOUser.builder()
                .name("Builder User")
                .email("builder@example.com")
                .password("builderpassword")
                .build();

        assertNotNull(userDTO, "InputDTOUser created with builder should not be null");
        assertEquals("Builder User", userDTO.getName(), "User name should be 'Builder User'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetName() {
        // Check if the name is as expected
        assertEquals("John Doe", testUserDTO.getName(), "User name should be 'John Doe'");
    }

    @Test
    void testGetEmail() {
        // Check if the email is as expected
        assertEquals("john.doe@example.com", testUserDTO.getEmail(), "User email should be 'john.doe@example.com'");
    }

    @Test
    void testGetPassword() {
        // Check if the password is as expected
        assertEquals("securepassword", testUserDTO.getPassword(), "User password should be 'securepassword'");
    }

    // Group 3: Setter Tests
    @Test
    void testSetName() {
        // Set a new name
        testUserDTO.setName("Updated Name");
        assertEquals("Updated Name", testUserDTO.getName(), "User name should be 'Updated Name'");
    }

    @Test
    void testSetEmail() {
        // Set a new email
        testUserDTO.setEmail("new.email@example.com");
        assertEquals("new.email@example.com", testUserDTO.getEmail(), "User email should be 'new.email@example.com'");
    }

    @Test
    void testSetPassword() {
        // Set a new password
        testUserDTO.setPassword("newpassword");
        assertEquals("newpassword", testUserDTO.getPassword(), "User password should be 'newpassword'");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another UserDTO with the same values
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();

        assertEquals(testUserDTO, userToCompare, "User DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another UserDTO with different values
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .password("differentpassword")
                .build();

        assertNotEquals(testUserDTO, userToCompare, "User DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another UserDTO with the same values
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();

        assertEquals(testUserDTO.hashCode(), userToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "InputDTOUser(name=John Doe, email=john.doe@example.com, password=securepassword)";
        assertEquals(expected, testUserDTO.toString(), "toString method should return the expected output");
    }
}
