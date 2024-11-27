package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputDTOUserTest {

    private InputDTOUser testUserDTO;

    @BeforeEach
    void setUp() {
        // Initialize the test InputDTOUser object
        testUserDTO = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();
    }

    // Group 1: Initialization and Builder Tests
    @Test
    void shouldInitializeNonNullUserDTO() {
        assertNotNull(testUserDTO, "Test UserDTO should not be null after initialization");
    }

    @Test
    void shouldCreateUserDTOUsingNoArgsConstructor() {
        InputDTOUser userDTO = new InputDTOUser();
        assertNotNull(userDTO, "InputDTOUser created with no-args constructor should not be null");
    }

    @Test
    void shouldCreateUserDTOUsingAllArgsConstructor() {
        InputDTOUser userDTO = new InputDTOUser(
                "Jane Doe",
                "jane.doe@example.com",
                "password123",
                "user",
                "https://avatar.iran.liara.run/public"
        );

        assertNotNull(userDTO, "InputDTOUser created with all-args constructor should not be null");
        assertEquals("Jane Doe", userDTO.getName(), "User name should be 'Jane Doe'");
        assertEquals("jane.doe@example.com", userDTO.getEmail(), "User email should match");
    }

    @Test
    void shouldCreateUserDTOUsingBuilder() {
        InputDTOUser userDTO = InputDTOUser.builder()
                .name("Builder User")
                .email("builder@example.com")
                .password("builderpassword")
                .build();

        assertNotNull(userDTO, "InputDTOUser created with builder should not be null");
        assertEquals("Builder User", userDTO.getName(), "User name should be 'Builder User'");
        assertEquals("builder@example.com", userDTO.getEmail(), "User email should match");
    }

    // Group 2: Getter Tests
    @Test
    void shouldReturnCorrectName() {
        assertEquals("John Doe", testUserDTO.getName(), "User name should be 'John Doe'");
    }

    @Test
    void shouldReturnCorrectEmail() {
        assertEquals("john.doe@example.com", testUserDTO.getEmail(), "User email should be 'john.doe@example.com'");
    }

    @Test
    void shouldReturnCorrectPassword() {
        assertEquals("securepassword", testUserDTO.getPassword(), "User password should be 'securepassword'");
    }

    // Group 3: Setter Tests
    @Test
    void shouldUpdateName() {
        testUserDTO.setName("Updated Name");
        assertEquals("Updated Name", testUserDTO.getName(), "User name should be updated to 'Updated Name'");
    }

    @Test
    void shouldUpdateEmail() {
        testUserDTO.setEmail("new.email@example.com");
        assertEquals("new.email@example.com", testUserDTO.getEmail(), "User email should be updated to 'new.email@example.com'");
    }

    @Test
    void shouldUpdatePassword() {
        testUserDTO.setPassword("newpassword");
        assertEquals("newpassword", testUserDTO.getPassword(), "User password should be updated to 'newpassword'");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void shouldReturnTrueForEqualUserDTOs() {
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();

        assertEquals(testUserDTO, userToCompare, "User DTOs with identical values should be equal");
    }

    @Test
    void shouldReturnFalseForNonEqualUserDTOs() {
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .password("differentpassword")
                .build();

        assertNotEquals(testUserDTO, userToCompare, "User DTOs with different values should not be equal");
    }

    @Test
    void shouldHaveSameHashCodeForEqualUserDTOs() {
        InputDTOUser userToCompare = InputDTOUser.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build();

        assertEquals(testUserDTO.hashCode(), userToCompare.hashCode(), "Hash codes should match for equal UserDTO objects");
    }

    @Test
    void toStringShouldReturnExpectedFormat() {
        String expected = "InputDTOUser(name=John Doe, email=john.doe@example.com, password=securepassword)";
        assertEquals(expected, testUserDTO.toString(), "toString method should return the expected format");
    }
}
