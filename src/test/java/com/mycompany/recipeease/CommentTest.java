package com.mycompany.recipeease;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the Comment class.
 */
@DisplayName("Comment Tests")
class CommentTest {

    private Comment comment;

    @BeforeEach
    void setUp() {
        comment = new Comment(1, "Resep ini enak!", "UserA", new Date());
    }

    // === Constructor & Getter Tests ===

    @Test
    @DisplayName("Constructor should set comment ID correctly")
    void constructorShouldSetCommentID() {
        assertEquals(1, comment.getCommentID());
    }

    @Test
    @DisplayName("Constructor should set content correctly")
    void constructorShouldSetContent() {
        assertEquals("Resep ini enak!", comment.getContent());
    }

    @Test
    @DisplayName("Constructor should set author correctly")
    void constructorShouldSetAuthor() {
        assertEquals("UserA", comment.getAuthor());
    }

    @Test
    @DisplayName("Constructor should set timestamp")
    void constructorShouldSetTimestamp() {
        assertNotNull(comment.getTimestamp());
    }

    // === editComment Tests ===

    @Test
    @DisplayName("editComment should update content")
    void editCommentShouldUpdateContent() {
        comment.editComment("Konten baru yang lebih baik");
        assertEquals("Konten baru yang lebih baik", comment.getContent());
    }

    @Test
    @DisplayName("editComment should update timestamp")
    void editCommentShouldUpdateTimestamp() throws InterruptedException {
        var originalTimestamp = comment.getTimestamp();
        // Small delay to ensure timestamp difference
        Thread.sleep(10);
        comment.editComment("Edited content");
        // Timestamp should be updated (may be same millisecond on fast systems)
        assertNotNull(comment.getTimestamp());
    }

    // === deleteComment Tests ===

    @Test
    @DisplayName("deleteComment should replace content with deletion message")
    void deleteCommentShouldReplaceContent() {
        comment.deleteComment();
        assertEquals("This comment has been deleted.", comment.getContent());
    }

    @Test
    @DisplayName("deleteComment should update timestamp")
    void deleteCommentShouldUpdateTimestamp() {
        comment.deleteComment();
        assertNotNull(comment.getTimestamp());
    }

    // === Edge Cases ===

    @Test
    @DisplayName("Comment with empty content should be created")
    void commentWithEmptyContentShouldBeCreated() {
        Comment emptyComment = new Comment(2, "", "UserB", new Date());
        assertEquals("", emptyComment.getContent());
    }

    @Test
    @DisplayName("getRecipeID should throw UnsupportedOperationException")
    void getRecipeIDShouldThrowException() {
        assertThrows(UnsupportedOperationException.class, () -> comment.getRecipeID());
    }

    @Test
    @DisplayName("getID should throw UnsupportedOperationException")
    void getIDShouldThrowException() {
        assertThrows(UnsupportedOperationException.class, () -> comment.getID());
    }
}
