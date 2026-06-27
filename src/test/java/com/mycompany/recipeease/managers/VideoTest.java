package com.mycompany.recipeease.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Video class.
 */
@DisplayName("Video Tests")
class VideoTest {

    private Video video;

    @BeforeEach
    void setUp() {
        video = new Video(1, "https://youtube.com/watch?v=abc123", 10);
    }

    @Test
    @DisplayName("Constructor should set video ID correctly")
    void constructorShouldSetVideoID() {
        assertEquals(1, video.getVideoID());
    }

    @Test
    @DisplayName("Constructor should set video link correctly")
    void constructorShouldSetVideoLink() {
        assertEquals("https://youtube.com/watch?v=abc123", video.getVideoLink());
    }

    @Test
    @DisplayName("Constructor should set recipe ID correctly")
    void constructorShouldSetRecipeID() {
        assertEquals(10, video.getRecipeID());
    }

    @Test
    @DisplayName("toString should contain video link")
    void toStringShouldContainVideoLink() {
        String result = video.toString();
        assertTrue(result.contains("https://youtube.com/watch?v=abc123"));
    }

    @Test
    @DisplayName("toString should contain video ID")
    void toStringShouldContainVideoID() {
        String result = video.toString();
        assertTrue(result.contains("1"));
    }
}
