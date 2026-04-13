package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void mainRunsWithoutExceptions() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}
