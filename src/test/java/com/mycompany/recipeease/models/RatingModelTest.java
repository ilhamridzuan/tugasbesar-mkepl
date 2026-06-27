package com.mycompany.recipeease.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Rating model class.
 */
@DisplayName("Rating Model Tests")
class RatingModelTest {

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating(1, 4.5f, "UserA", "Nasi Goreng");
    }

    // === Constructor & Getter Tests ===

    @Test
    @DisplayName("Constructor should set rating ID correctly")
    void constructorShouldSetRatingID() {
        assertEquals(1, rating.getRatingID());
    }

    @Test
    @DisplayName("Constructor should set score correctly")
    void constructorShouldSetScore() {
        assertEquals(4.5f, rating.getScore(), 0.001f);
    }

    @Test
    @DisplayName("Constructor should set user correctly")
    void constructorShouldSetUser() {
        assertEquals("UserA", rating.getUser());
    }

    @Test
    @DisplayName("Constructor should set recipe correctly")
    void constructorShouldSetRecipe() {
        assertEquals("Nasi Goreng", rating.getRecipe());
    }

    // === setRating Tests ===

    @Test
    @DisplayName("setRating should update score")
    void setRatingShouldUpdateScore() {
        rating.setRating(3.0f);
        assertEquals(3.0f, rating.getScore(), 0.001f);
    }

    @Test
    @DisplayName("setRating should accept zero score")
    void setRatingShouldAcceptZeroScore() {
        rating.setRating(0.0f);
        assertEquals(0.0f, rating.getScore(), 0.001f);
    }

    @Test
    @DisplayName("setRating should accept maximum score")
    void setRatingShouldAcceptMaxScore() {
        rating.setRating(5.0f);
        assertEquals(5.0f, rating.getScore(), 0.001f);
    }

    // === getRecipeTitle Tests ===

    @Test
    @DisplayName("getRecipeTitle should return recipe name")
    void getRecipeTitleShouldReturnRecipeName() {
        assertEquals("Nasi Goreng", rating.getRecipeTitle());
    }

    @Test
    @DisplayName("getRecipeTitle should match getRecipe")
    void getRecipeTitleShouldMatchGetRecipe() {
        assertEquals(rating.getRecipe(), rating.getRecipeTitle());
    }

    // === Edge Cases ===

    @Test
    @DisplayName("Rating with negative score should be created")
    void ratingWithNegativeScoreShouldBeCreated() {
        Rating negativeRating = new Rating(2, -1.0f, "UserB", "Bad Recipe");
        assertEquals(-1.0f, negativeRating.getScore(), 0.001f);
    }

    @Test
    @DisplayName("Multiple ratings for same recipe should be independent")
    void multipleRatingsForSameRecipeShouldBeIndependent() {
        Rating rating2 = new Rating(2, 3.0f, "UserB", "Nasi Goreng");
        assertNotEquals(rating.getScore(), rating2.getScore());
        assertEquals(rating.getRecipe(), rating2.getRecipe());
    }
}
