package com.fontys.crowdfund.testPersistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.fontys.crowdfund.persistence.entity.UserEntity;
import com.fontys.crowdfund.persistence.UserRepository;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class TestH2Database {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static UserEntity u1;



    @Test
    @DisplayName("Print All Database Tables")
    void printDatabaseContents() {
        List<String> tables = jdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema='PUBLIC'",
                String.class
        );

        for (String table : tables) {
            System.out.println("Contents of table: " + table);
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM " + table);
            rows.forEach(row -> System.out.println(row));
            System.out.println();
        }
    }

    @Test
    @DisplayName("Test 1")
    void testName() {
        assertEquals("Matthew Stone", u1.getName());
    }
}
