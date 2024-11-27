package com.fontys.crowdfund.testPersistence.Entity;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityPersistenceTest {

    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        testUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();
    }

    // Group 1: Initialization and Builder Tests
    @Test
    void userEntityShouldNotBeNullAfterInitialization() {
        assertNotNull(testUser, "Test user should not be null after initialization");
    }

    @Test
    void noArgsConstructorShouldCreateNonNullUserEntity() {
        UserEntity user = new UserEntity();
        assertNotNull(user, "UserEntity created with no-args constructor should not be null");
    }

    @Test
    void allArgsConstructorShouldCreateUserEntityWithGivenValues() {
        HashSet<ProjectEntity> projects = new HashSet<>();
        UserEntity user = new UserEntity(2, "name", "email@example.com", "password", projects, "user", "https://avatar.iran.liara.run/public");

        assertNotNull(user, "UserEntity created with all-args constructor should not be null");
        assertEquals(2, user.getId(), "User ID should be 2");
        assertEquals("name", user.getName(), "User name should be 'name'");
        assertEquals("email@example.com", user.getEmail(), "User email should match");
    }

    @Test
    void builderShouldCreateUserEntityWithSpecifiedValues() {
        UserEntity user = UserEntity.builder()
                .id(3)
                .name("Another User")
                .email("another@email.com")
                .password("anotherpassword")
                .projects(new HashSet<>())
                .build();

        assertNotNull(user, "UserEntity created with builder should not be null");
        assertEquals(3, user.getId(), "User ID should be 3");
        assertEquals("Another User", user.getName(), "User name should be 'Another User'");
    }

    // Group 2: Getter Tests
    @Test
    void shouldReturnCorrectUserId() {
        assertEquals(1, testUser.getId(), "User ID should be 1");
    }

    @Test
    void shouldReturnCorrectUserEmail() {
        assertEquals("user@email.com", testUser.getEmail(), "User email should match");
    }

    @Test
    void shouldReturnCorrectUserName() {
        assertEquals("user name", testUser.getName(), "User name should match");
    }

    @Test
    void shouldReturnCorrectUserPassword() {
        assertEquals("user password", testUser.getPassword(), "User password should match");
    }

    @Test
    void shouldReturnEmptyProjectsInitially() {
        assertNotNull(testUser.getProjects(), "Projects set should not be null");
        assertTrue(testUser.getProjects().isEmpty(), "Projects set should be empty initially");
    }

    // Group 3: Setter Tests
    @Test
    void shouldSetUserId() {
        testUser.setId(2);
        assertEquals(2, testUser.getId(), "User ID should be 2 after setting");
    }

    @Test
    void shouldSetUserName() {
        testUser.setName("new user name");
        assertEquals("new user name", testUser.getName(), "User name should be updated");
    }

    @Test
    void shouldSetUserEmail() {
        testUser.setEmail("newuser@email.com");
        assertEquals("newuser@email.com", testUser.getEmail(), "User email should be updated");
    }

    @Test
    void shouldSetUserPassword() {
        testUser.setPassword("new password");
        assertEquals("new password", testUser.getPassword(), "User password should be updated");
    }

    @Test
    void shouldSetUserProjects() {
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
    void shouldAddProjectToUserProjects() {
        ProjectEntity project = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .build();

        testUser.getProjects().add(project);

        assertEquals(1, testUser.getProjects().size(), "Projects set should contain 1 project");
        assertTrue(testUser.getProjects().contains(project), "Projects set should contain the added project");
    }

    // Group 5: Object Method Tests (equals, hashCode, toString)
    @Test
    void equalsShouldReturnTrueForIdenticalUsers() {
        UserEntity identicalUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();

        assertEquals(testUser, identicalUser, "Equals should return true for identical users");
    }

    @Test
    void equalsShouldReturnFalseForDifferentUsers() {
        UserEntity differentUser = UserEntity.builder()
                .id(2)
                .email("different@email.com")
                .name("different name")
                .password("different password")
                .projects(new HashSet<>())
                .build();

        assertNotEquals(testUser, differentUser, "Equals should return false for different users");
    }

    @Test
    void hashCodeShouldBeIdenticalForEqualUsers() {
        UserEntity identicalUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .projects(new HashSet<>())
                .build();

        assertEquals(testUser.hashCode(), identicalUser.hashCode(), "Hash codes should match for equal users");
    }

    //TO-DO
    @Disabled
    @Test
    void toStringShouldReturnExpectedFormat() {
        String expected = "UserEntity(id=1, name=user name, email=user@email.com, password=user password, projects=[])";
        assertEquals(expected, testUser.toString(), "toString should return the expected format");
    }
}
