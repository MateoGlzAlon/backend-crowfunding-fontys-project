package com.fontys.crowdfund.testPersistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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

/*

    @Disabled
    @Test
    @DisplayName("Print All Database Tables with Columns")
    void printDatabaseContents() {
        List<String> tables = jdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema='PUBLIC'",
                String.class
        );

        for (String table : tables) {
            System.out.println("Table: " + table);

            // Fetch and print column names
            List<Map<String, Object>> columns = jdbcTemplate.queryForList(
                    "SELECT column_name, data_type FROM information_schema.columns WHERE table_name = ?",
                    table
            );
            System.out.println("Columns:");
            columns.forEach(column -> System.out.println(column));

            // Fetch and print rows of the table
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM " + table);
            System.out.println("Data:");
            rows.forEach(row -> System.out.println(row));
            System.out.println();
        }
    }

    @Disabled
    @Test
    @DisplayName("Test 1")
    void testName() {
        assertEquals("Matthew Stone", u1.getName());
    }


 */
}
