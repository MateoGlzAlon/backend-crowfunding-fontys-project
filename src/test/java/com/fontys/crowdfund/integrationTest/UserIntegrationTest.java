package com.fontys.crowdfund.integrationTest;

import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void find_user_by_id() {
        UserEntity savedUser = userRepository.findById(1);
        // Initialize the projects collection to avoid lazy-loading issues
        Hibernate.initialize(savedUser.getProjects());

        assertEquals(1, savedUser.getId());
        assertEquals("Matthew Stone", savedUser.getName());
    }

    @Test
    void find_all_users() {
        List<UserEntity> allUsers = userRepository.findAll();
        assertEquals(6, allUsers.size());
    }
}
