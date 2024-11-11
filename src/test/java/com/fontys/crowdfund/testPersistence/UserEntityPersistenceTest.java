package com.fontys.crowdfund.testPersistence;

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

    @Test
    void testUserNotNull() {
        // Check if testUser is not null
        assertNotNull(testUser, "Test user should not be null");
    }

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
}