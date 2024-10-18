package com.example.demo.controller;

import com.example.demo.dto.response.ApiResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseTestController extends BaseController{

    private final JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseTestController.class);

    public DatabaseTestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test-db-connection")
    public ResponseEntity<ApiResponseDTO<String>> testDatabaseConnection() {
        // Test Logging capabilities, logs to console and to file
        logger.error("error log");
        logger.warn("warning log");
        logger.info("info log");
        logger.debug("debug log");
        logger.trace("trace log");

        return runInTransaction(() -> {
            // Run a simple query to check connection
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Database connection successful!";
        });
    }
}
