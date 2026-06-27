package com.mycompany.recipeease.managers;

import com.mycompany.recipeease.Comment;
import com.mycompany.recipeease.utils.InvalidRatingException;
import com.mycompany.recipeease.models.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Community manager class.
 */
@DisplayName("Community Manager Tests")
class CommunityManagerTest {

    private Community community;

    @BeforeEach
    void setUp() {
        community = new Community();
    }

    // === Comment Tests ===

    @Test
    @DisplayName("New community should have empty comment list")
    void newCommunityShouldHaveEmptyComments() {
        assertTrue(community.getComments().isEmpty());
    }

    @Test
    @DisplayName("addComment should add comment to list")
    void addCommentShouldAddToList() {
        Comment comment = new Comment(1, "Great recipe!", "UserA", new Date());
        community.addComment(comment);
        assertEquals(1, community.getComments().size());
    }

    @Test
    @DisplayName("addComment should store correct comment content")
    void addCommentShouldStoreCorrectContent() {
        Comment comment = new Comment(1, "Enak sekali!", "UserB", new Date());
        community.addComment(comment);
        assertEquals("Enak sekali!", community.getComments().get(0).getContent());
    }

    @Test
    @DisplayName("Multiple comments should be stored in order")
    void multipleCommentsShouldBeStoredInOrder() {
        Comment c1 = new Comment(1, "Komentar 1", "UserA", new Date());
        Comment c2 = new Comment(2, "Komentar 2", "UserB", new Date());
        Comment c3 = new Comment(3, "Komentar 3", "UserC", new Date());

        community.addComment(c1);
        community.addComment(c2);
        community.addComment(c3);

        assertEquals(3, community.getComments().size());
        assertEquals("Komentar 1", community.getComments().get(0).getContent());
        assertEquals("Komentar 3", community.getComments().get(2).getContent());
    }

    @Test
    @DisplayName("clearComments should remove all comments")
    void clearCommentsShouldRemoveAll() {
        community.addComment(new Comment(1, "Test", "User", new Date()));
        community.addComment(new Comment(2, "Test2", "User2", new Date()));
        community.clearComments();
        assertTrue(community.getComments().isEmpty());
    }

    // === Like Tests ===

    @Test
    @DisplayName("New community should have zero likes")
    void newCommunityShouldHaveZeroLikes() {
        assertEquals(0, community.getLikes());
    }

    @Test
    @DisplayName("addLike should increment likes by one")
    void addLikeShouldIncrementByOne() {
        community.addLike();
        assertEquals(1, community.getLikes());
    }

    @Test
    @DisplayName("Multiple addLike calls should increment correctly")
    void multipleAddLikesShouldIncrementCorrectly() {
        community.addLike();
        community.addLike();
        community.addLike();
        assertEquals(3, community.getLikes());
    }

    @Test
    @DisplayName("resetLikes should set likes to zero")
    void resetLikesShouldSetToZero() {
        community.addLike();
        community.addLike();
        community.resetLikes();
        assertEquals(0, community.getLikes());
    }

    // === Rating Tests ===

    @Test
    @DisplayName("New community should have empty rating list")
    void newCommunityShouldHaveEmptyRatings() {
        assertTrue(community.getRatings().isEmpty());
    }

    @Test
    @DisplayName("addRating should add rating to list")
    void addRatingShouldAddToList() throws InvalidRatingException {
        Rating rating = new Rating(1, 4.5f, "UserA", "Nasi Goreng");
        community.addRating(rating);
        assertEquals(1, community.getRatings().size());
    }

    @Test
    @DisplayName("addRating should store correct score")
    void addRatingShouldStoreCorrectScore() throws InvalidRatingException {
        Rating rating = new Rating(1, 3.5f, "UserA", "Sate Ayam");
        community.addRating(rating);
        assertEquals(3.5f, community.getRatings().get(0).getScore(), 0.001f);
    }

    // === Average Rating Tests ===

    @Test
    @DisplayName("getAverageRatingByRecipe should return empty map when no ratings")
    void getAverageRatingShouldReturnEmptyMapWhenNoRatings() {
        Map<String, Float> averages = community.getAverageRatingByRecipe();
        assertTrue(averages.isEmpty());
    }

    @Test
    @DisplayName("getAverageRatingByRecipe should calculate average for single recipe")
    void getAverageRatingShouldCalculateForSingleRecipe() throws InvalidRatingException {
        community.addRating(new Rating(1, 4.0f, "UserA", "Nasi Goreng"));
        community.addRating(new Rating(2, 5.0f, "UserB", "Nasi Goreng"));

        Map<String, Float> averages = community.getAverageRatingByRecipe();
        assertEquals(4.5f, averages.get("Nasi Goreng"), 0.001f);
    }

    @Test
    @DisplayName("getAverageRatingByRecipe should calculate averages for multiple recipes")
    void getAverageRatingShouldCalculateForMultipleRecipes() throws InvalidRatingException {
        community.addRating(new Rating(1, 4.0f, "UserA", "Nasi Goreng"));
        community.addRating(new Rating(2, 5.0f, "UserB", "Nasi Goreng"));
        community.addRating(new Rating(3, 3.0f, "UserA", "Sate Ayam"));

        Map<String, Float> averages = community.getAverageRatingByRecipe();
        assertEquals(2, averages.size());
        assertEquals(4.5f, averages.get("Nasi Goreng"), 0.001f);
        assertEquals(3.0f, averages.get("Sate Ayam"), 0.001f);
    }

    @Test
    @DisplayName("calculateAverageRatingForRecipe should return 0 for unknown recipe")
    void calculateAverageForUnknownRecipeShouldReturnZero() {
        float avg = community.calculateAverageRatingForRecipe("Unknown Recipe");
        assertEquals(0.0f, avg, 0.001f);
    }

    @Test
    @DisplayName("calculateAverageRatingForRecipe should calculate correctly")
    void calculateAverageForRecipeShouldCalculateCorrectly() throws InvalidRatingException {
        community.addRating(new Rating(1, 3.0f, "UserA", "Nasi Goreng"));
        community.addRating(new Rating(2, 4.0f, "UserB", "Nasi Goreng"));
        community.addRating(new Rating(3, 5.0f, "UserC", "Nasi Goreng"));

        float avg = community.calculateAverageRatingForRecipe("Nasi Goreng");
        assertEquals(4.0f, avg, 0.001f);
    }

    @Test
    @DisplayName("calculateAverageRatingForRecipe should be case insensitive")
    void calculateAverageForRecipeShouldBeCaseInsensitive() throws InvalidRatingException {
        community.addRating(new Rating(1, 4.0f, "UserA", "Nasi Goreng"));

        float avg = community.calculateAverageRatingForRecipe("nasi goreng");
        assertEquals(4.0f, avg, 0.001f);
    }
}
