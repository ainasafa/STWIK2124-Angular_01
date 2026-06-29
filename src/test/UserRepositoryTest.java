package com.example.musicapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    // TEST 1: simple success test
    @Test
    void testExampleSuccess() {
        int a = 2 + 2;
        assertEquals(4, a);
    }

    // TEST 2: another success test
    @Test
    void testString() {
        String name = "music";
        assertNotNull(name);
    }

    // TEST 3: failure-style test
    @Test
    void testFailureCase() {
        String value = null;
        assertNull(value);
    }
}
