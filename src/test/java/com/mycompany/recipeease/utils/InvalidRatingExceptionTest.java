package com.mycompany.recipeease.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the InvalidRatingException class.
 */
@DisplayName("InvalidRatingException Tests")
class InvalidRatingExceptionTest {

    @Test
    @DisplayName("Should be an instance of Exception")
    void shouldBeInstanceOfException() {
        InvalidRatingException ex = new InvalidRatingException("test");
        assertInstanceOf(Exception.class, ex);
    }

    @Test
    @DisplayName("Constructor with message should set message")
    void constructorWithMessageShouldSetMessage() {
        InvalidRatingException ex = new InvalidRatingException("Rating tidak valid");
        assertEquals("Rating tidak valid", ex.getMessage());
    }

    @Test
    @DisplayName("Constructor with message and cause should set both")
    void constructorWithMessageAndCauseShouldSetBoth() {
        Throwable cause = new RuntimeException("original error");
        InvalidRatingException ex = new InvalidRatingException("Rating error", cause);
        assertEquals("Rating error", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    @DisplayName("Constructor with cause should set cause")
    void constructorWithCauseShouldSetCause() {
        Throwable cause = new RuntimeException("root cause");
        InvalidRatingException ex = new InvalidRatingException(cause);
        assertEquals(cause, ex.getCause());
    }

    @Test
    @DisplayName("Exception should be throwable and catchable")
    void exceptionShouldBeThrowableAndCatchable() {
        assertThrows(InvalidRatingException.class, () -> {
            throw new InvalidRatingException("Test throw");
        });
    }
}
