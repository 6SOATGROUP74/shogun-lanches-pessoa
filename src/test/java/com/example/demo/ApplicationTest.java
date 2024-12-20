package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ApplicationTest {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> Application.main(new String[]{}));
    }
}
