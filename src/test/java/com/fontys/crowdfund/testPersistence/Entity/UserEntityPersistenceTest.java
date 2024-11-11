package com.fontys.crowdfund.testPersistence.Entity;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityPersistenceTest {

    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        // Initialize testUser before each test
        testUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testUserNotNull() {
        // Check if testUser is not null
        assertNotNull(testUser, "Test user should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that a UserEntity can be created using no-args constructor
        UserEntity user = new UserEntity();
        assertNotNull(user, "UserEntity created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that a UserEntity can be created with all args constructor
        HashSet<ProjectEntity> projects = new HashSet<>();
        UserEntity user = new UserEntity(2, "name", "email@example.com", "password", projects);
        assertNotNull(user, "UserEntity created with all-args constructor should not be null");
        assertEquals(2, user.getId(), "User ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure thact a UserEntity can be created using the builder
        UserEntity user = UserEntity.builder()
                .id(3)
                .name("Another User")
                .email("another@email.com")
                .password("anotherpassword")
                .projects(new HashSet<>())
                .build();

        assertNotNull(user, "UserEntity created with builder should not be null");
        assertEquals("Another User", user.getName(), "User name should be 'Another User'");
    }

    // Group 2: Getter Tests
    @Test
    void testUserId() {
        // Check if user ID is as expected
        assertEquals(1, testUser.getId(), "User ID should be 1");
    }

    @Test
    void testUserEmail() {
        // Check if user email is as expected
        assertEquals("user@email.com", testUser.getEmail(), "User email should be 'user@email.com'");
    }

    @Test
    void testUserName() {
        // Check if user name is as expected
        assertEquals("user name", testUser.getName(), "User name should be 'user name'");
    }

    @Test
    void testUserPassword() {
        // Check if user password is as expected
        assertEquals("user password", testUser.getPassword(), "User password should be 'user password'");
    }

    @Test
    void testUserProjectsEmpty() {
        // Verify that projects set is empty initially
        assertNotNull(testUser.getProjects(), "Projects set should not be null");
        assertTrue(testUser.getProjects().isEmpty(), "Projects set should be empty initially");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new ID
        testUser.setId(2);
        assertEquals(2, testUser.getId(), "User ID should be 2");
    }

    @Test
    void testSetName() {
        // Set a new name
        testUser.setName("new user name");
        assertEquals("new user name", testUser.getName(), "User name should be 'new user name'");
    }

    @Test
    void testSetEmail() {
        // Set a new email
        testUser.setEmail("newuser@email.com");
        assertEquals("newuser@email.com", testUser.getEmail(), "User email should be 'newuser@email.com'");
    }

    @Test
    void testSetPassword() {
        // Set a new password
        testUser.setPassword("new password");
        assertEquals("new password", testUser.getPassword(), "User password should be 'new password'");
    }

    @Test
    void testSetProjects() {
        // Set a new projects set
        HashSet<ProjectEntity> newProjects = new HashSet<>();
        ProjectEntity project = ProjectEntity.builder()
                .id(2)
                .name("Another Project")
                .build();
        newProjects.add(project);
        testUser.setProjects(newProjects);

        assertEquals(1, testUser.getProjects().size(), "Projects set should contain 1 project");
    }

    // Group 4: Relationship Tests
    @Test
    void testAddProjectToUser() {
        // Create a new ProjectEntity to add to testUser
        ProjectEntity project = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .build();

        // Add the project to the user's projects set
        testUser.getProjects().add(project);

        // Verify that the project was added
        assertEquals(1, testUser.getProjects().size(), "Projects set should contain 1 project");
    }

    // Group 5: Object Method Tests (equals, hashCode, toString, canEqual)
    @Test
    void testEquals() {
        // Create another user with the same values
        UserEntity userToCompare = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();

        assertEquals(testUser, userToCompare, "Users should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another user with different values
        UserEntity userToCompare = UserEntity.builder()
                .id(2)
                .email("different@email.com")
                .name("different name")
                .password("different password")
                .projects(new HashSet<>())
                .build();

        assertNotEquals(testUser, userToCompare, "Users should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another user with the same values
        UserEntity userToCompare = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();

        assertEquals(testUser.hashCode(), userToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "UserEntity(id=1, name=user name, email=user@email.com, password=user password, projects=[])";
        assertEquals(expected, testUser.toString(), "toString method should return the expected output");
    }
}
