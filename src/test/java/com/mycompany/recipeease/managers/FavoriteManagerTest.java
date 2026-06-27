package com.mycompany.recipeease.managers;

import com.mycompany.recipeease.models.Recipe;
import com.mycompany.recipeease.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Favorite manager class.
 */
@DisplayName("Favorite Manager Tests")
class FavoriteManagerTest {

    private Favorite favorite;
    private User user;
    private Recipe recipe1;
    private Recipe recipe2;

    @BeforeEach
    void setUp() {
        user = new User(1, "testuser", "pass", "test@email.com", "user");
        favorite = new Favorite(user);
        recipe1 = new Recipe(1, "Nasi Goreng", "Nasi, Telur, Bawang", "Goreng semua");
        recipe2 = new Recipe(2, "Sate Ayam", "Ayam, Kecap, Bumbu kacang", "Bakar ayam");
    }

    // === Constructor Tests ===

    @Test
    @DisplayName("Constructor should set user correctly")
    void constructorShouldSetUser() {
        assertEquals(user, favorite.getUser());
    }

    @Test
    @DisplayName("Constructor should initialize empty favorite list")
    void constructorShouldInitializeEmptyList() {
        assertTrue(favorite.getFavoriteRecipes().isEmpty());
    }

    // === addFavoriteRecipe Tests ===

    @Test
    @DisplayName("addFavoriteRecipe should add recipe to favorites")
    void addFavoriteRecipeShouldAdd() {
        favorite.addFavoriteRecipe(recipe1);
        assertEquals(1, favorite.getFavoriteRecipes().size());
    }

    @Test
    @DisplayName("addFavoriteRecipe should store the correct recipe")
    void addFavoriteRecipeShouldStoreCorrectRecipe() {
        favorite.addFavoriteRecipe(recipe1);
        assertEquals("Nasi Goreng", favorite.getFavoriteRecipes().get(0).getTitle());
    }

    @Test
    @DisplayName("addFavoriteRecipe should allow multiple different recipes")
    void addFavoriteRecipeShouldAllowMultiple() {
        favorite.addFavoriteRecipe(recipe1);
        favorite.addFavoriteRecipe(recipe2);
        assertEquals(2, favorite.getFavoriteRecipes().size());
    }

    @Test
    @DisplayName("addFavoriteRecipe should prevent duplicate recipes")
    void addFavoriteRecipeShouldPreventDuplicates() {
        favorite.addFavoriteRecipe(recipe1);
        favorite.addFavoriteRecipe(recipe1); // duplicate
        assertEquals(1, favorite.getFavoriteRecipes().size());
    }

    // === removeFavoriteRecipe Tests ===

    @Test
    @DisplayName("removeFavoriteRecipe should remove existing recipe")
    void removeFavoriteRecipeShouldRemove() {
        favorite.addFavoriteRecipe(recipe1);
        favorite.removeFavoriteRecipe(recipe1);
        assertTrue(favorite.getFavoriteRecipes().isEmpty());
    }

    @Test
    @DisplayName("removeFavoriteRecipe should not throw for non-existing recipe")
    void removeFavoriteRecipeShouldNotThrowForNonExisting() {
        assertDoesNotThrow(() -> favorite.removeFavoriteRecipe(recipe1));
    }

    @Test
    @DisplayName("removeFavoriteRecipe should only remove specified recipe")
    void removeFavoriteRecipeShouldOnlyRemoveSpecified() {
        favorite.addFavoriteRecipe(recipe1);
        favorite.addFavoriteRecipe(recipe2);
        favorite.removeFavoriteRecipe(recipe1);
        assertEquals(1, favorite.getFavoriteRecipes().size());
        assertEquals("Sate Ayam", favorite.getFavoriteRecipes().get(0).getTitle());
    }

    // === viewFavoriteRecipes Tests ===

    @Test
    @DisplayName("viewFavoriteRecipes should not throw when empty")
    void viewFavoriteRecipesShouldNotThrowWhenEmpty() {
        assertDoesNotThrow(() -> favorite.viewFavoriteRecipes());
    }

    @Test
    @DisplayName("viewFavoriteRecipes should not throw with recipes")
    void viewFavoriteRecipesShouldNotThrowWithRecipes() {
        favorite.addFavoriteRecipe(recipe1);
        assertDoesNotThrow(() -> favorite.viewFavoriteRecipes());
    }

    // === getUser Tests ===

    @Test
    @DisplayName("getUser should return the correct user")
    void getUserShouldReturnCorrectUser() {
        assertEquals("testuser", favorite.getUser().getUsername());
    }
}
