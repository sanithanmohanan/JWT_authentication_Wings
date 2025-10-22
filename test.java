package com.example.jwt.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    private JwtUtil jwtUtil;
    private String token;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        token = jwtUtil.generateToken("devaprasad");
    }

    @Test
    void testTokenGeneration() {
        assertNotNull(token, "Token should not be null");
        System.out.println("Generated Token: " + token);
    }

    @Test
    void testTokenValidation() {
        assertTrue(jwtUtil.validateToken(token), "Token should be valid");
    }

    @Test
    void testExtractUsername() {
        String username = jwtUtil.extractUsername(token);
        assertEquals("devaprasad", username, "Username should match");
    }

    @Test
    void testInvalidToken() {
        String invalidToken = token + "abc";
        assertFalse(jwtUtil.validateToken(invalidToken), "Invalid token should fail validation");
    }
}
