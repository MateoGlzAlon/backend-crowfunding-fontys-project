package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.OutputDTOUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutputDTOUserTest {

    private OutputDTOUser testUserDTO;

    @BeforeEach
    void setUp() {
        // Initialize testUserDTO
        testUserDTO = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
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
        // Ensure that an OutputDTOUser can be created using no-args constructor
        OutputDTOUser userDTO = new OutputDTOUser();
        assertNotNull(userDTO, "OutputDTOUser created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an OutputDTOUser can be created with all args constructor
        OutputDTOUser userDTO = new OutputDTOUser(2L, "Jane Doe", "jane.doe@example.com");
        assertNotNull(userDTO, "OutputDTOUser created with all-args constructor should not be null");
        assertEquals(2L, userDTO.getId(), "User ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that an OutputDTOUser can be created using the builder
        OutputDTOUser userDTO = OutputDTOUser.builder()
                .id(3L)
                .name("Builder User")
                .email("builder@example.com")
                .build();

        assertNotNull(userDTO, "OutputDTOUser created with builder should not be null");
        assertEquals("Builder User", userDTO.getName(), "User name should be 'Builder User'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetId() {
        // Check if the user ID is as expected
        assertEquals(1L, testUserDTO.getId(), "User ID should be 1");
    }

    @Test
    void testGetName() {
        // Check if the user name is as expected
        assertEquals("John Doe", testUserDTO.getName(), "User name should be 'John Doe'");
    }

    @Test
    void testGetEmail() {
        // Check if the user email is as expected
        assertEquals("john.doe@example.com", testUserDTO.getEmail(), "User email should be 'john.doe@example.com'");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new user ID
        testUserDTO.setId(2L);
        assertEquals(2L, testUserDTO.getId(), "User ID should be 2");
    }

    @Test
    void testSetName() {
        // Set a new user name
        testUserDTO.setName("Jane Doe");
        assertEquals("Jane Doe", testUserDTO.getName(), "User name should be 'Jane Doe'");
    }

    @Test
    void testSetEmail() {
        // Set a new user email
        testUserDTO.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", testUserDTO.getEmail(), "User email should be 'jane.doe@example.com'");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another UserDTO with the same values
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        assertEquals(testUserDTO, userToCompare, "User DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another UserDTO with different values
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(2L)
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .build();

        assertNotEquals(testUserDTO, userToCompare, "User DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another UserDTO with the same values
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        assertEquals(testUserDTO.hashCode(), userToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "OutputDTOUser(id=1, name=John Doe, email=john.doe@example.com)";
        assertEquals(expected, testUserDTO.toString(), "toString method should return the expected output");
    }
}
