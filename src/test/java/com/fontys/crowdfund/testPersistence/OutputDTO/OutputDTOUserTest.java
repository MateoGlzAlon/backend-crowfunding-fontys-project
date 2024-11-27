package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutputDTOUserTest {

    private OutputDTOUser testUserDTO;

    @BeforeEach
    void setUp() {
        // Initialize the test UserDTO object before each test
        testUserDTO = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();
    }

    // Group 1: Initialization and Builder Tests
    @Test
    void shouldNotBeNullAfterInitialization() {
        assertNotNull(testUserDTO, "Test UserDTO should not be null after initialization");
    }

    @Test
    void shouldCreateNonNullUserDTOUsingNoArgsConstructor() {
        OutputDTOUser userDTO = new OutputDTOUser();
        assertNotNull(userDTO, "OutputDTOUser created with no-args constructor should not be null");
    }

    @Test
    void shouldCreateUserDTOUsingAllArgsConstructor() {
        OutputDTOUser userDTO = new OutputDTOUser(
                2L, "Jane Doe", "jane.doe@example.com", "user", "https://avatar.iran.liara.run/public"
        );

        assertNotNull(userDTO, "OutputDTOUser created with all-args constructor should not be null");
        assertEquals(2L, userDTO.getId(), "User ID should be 2");
        assertEquals("Jane Doe", userDTO.getName(), "User name should be 'Jane Doe'");
        assertEquals("jane.doe@example.com", userDTO.getEmail(), "User email should match");
    }

    @Test
    void shouldCreateUserDTOUsingBuilder() {
        OutputDTOUser userDTO = OutputDTOUser.builder()
                .id(3L)
                .name("Builder User")
                .email("builder@example.com")
                .build();

        assertNotNull(userDTO, "OutputDTOUser created with builder should not be null");
        assertEquals(3L, userDTO.getId(), "User ID should be 3");
        assertEquals("Builder User", userDTO.getName(), "User name should be 'Builder User'");
    }

    // Group 2: Getter Tests
    @Test
    void shouldReturnCorrectId() {
        assertEquals(1L, testUserDTO.getId(), "User ID should be 1");
    }

    @Test
    void shouldReturnCorrectName() {
        assertEquals("John Doe", testUserDTO.getName(), "User name should be 'John Doe'");
    }

    @Test
    void shouldReturnCorrectEmail() {
        assertEquals("john.doe@example.com", testUserDTO.getEmail(), "User email should be 'john.doe@example.com'");
    }

    // Group 3: Setter Tests
    @Test
    void shouldSetIdCorrectly() {
        testUserDTO.setId(2L);
        assertEquals(2L, testUserDTO.getId(), "User ID should be updated to 2");
    }

    @Test
    void shouldSetNameCorrectly() {
        testUserDTO.setName("Jane Doe");
        assertEquals("Jane Doe", testUserDTO.getName(), "User name should be updated to 'Jane Doe'");
    }

    @Test
    void shouldSetEmailCorrectly() {
        testUserDTO.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", testUserDTO.getEmail(), "User email should be updated to 'jane.doe@example.com'");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void shouldReturnTrueForEqualDTOs() {
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        assertEquals(testUserDTO, userToCompare, "UserDTO objects with identical values should be equal");
    }

    @Test
    void shouldReturnFalseForNonEqualDTOs() {
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(2L)
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .build();

        assertNotEquals(testUserDTO, userToCompare, "UserDTO objects with different values should not be equal");
    }

    @Test
    void shouldHaveSameHashCodeForEqualDTOs() {
        OutputDTOUser userToCompare = OutputDTOUser.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build();

        assertEquals(testUserDTO.hashCode(), userToCompare.hashCode(), "Hash codes should match for equal UserDTO objects");
    }

    //TO-DO
    @Disabled
    @Test
    void toStringShouldReturnExpectedFormat() {
        String expected = "OutputDTOUser(id=1, name=John Doe, email=john.doe@example.com)";
        assertEquals(expected, testUserDTO.toString(), "toString method should return the expected format");
    }
}
