package com.mycompany.recipeease.managers;

import com.mycompany.recipeease.models.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RecipeManager class.
 */
@DisplayName("RecipeManager Tests")
class RecipeManagerTest {

    private RecipeManager manager;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    @BeforeEach
    void setUp() {
        manager = new RecipeManager();
        recipe1 = new Recipe(1, "Nasi Goreng", "Nasi, Telur, Bawang", "Goreng semua");
        recipe2 = new Recipe(2, "Sate Ayam", "Ayam, Kecap, Bumbu kacang", "Bakar ayam");
        recipe3 = new Recipe(3, "Rendang", "Daging, Santan, Bumbu", "Masak lama");
    }

    // === addRecipe Tests ===

    @Test
    @DisplayName("addRecipe should add recipe to saved recipes")
    void addRecipeShouldAdd() {
        manager.addRecipe(recipe1);
        assertEquals(1, manager.getSavedRecipes().size());
    }

    @Test
    @DisplayName("addRecipe should store correct recipe")
    void addRecipeShouldStoreCorrect() {
        manager.addRecipe(recipe1);
        assertEquals("Nasi Goreng", manager.getSavedRecipes().get(0).getTitle());
    }

    @Test
    @DisplayName("addRecipe should allow multiple recipes")
    void addRecipeShouldAllowMultiple() {
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.addRecipe(recipe3);
        assertEquals(3, manager.getSavedRecipes().size());
    }

    // === deleteRecipe Tests ===

    @Test
    @DisplayName("deleteRecipe should remove recipe by ID")
    void deleteRecipeShouldRemoveByID() {
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.deleteRecipe(1);
        assertEquals(1, manager.getSavedRecipes().size());
        assertEquals("Sate Ayam", manager.getSavedRecipes().get(0).getTitle());
    }

    @Test
    @DisplayName("deleteRecipe should do nothing for non-existing ID")
    void deleteRecipeShouldDoNothingForNonExistingID() {
        manager.addRecipe(recipe1);
        manager.deleteRecipe(999);
        assertEquals(1, manager.getSavedRecipes().size());
    }

    // === searchRecipe Tests ===

    @Test
    @DisplayName("searchRecipe should find recipe by exact title")
    void searchRecipeShouldFindByTitle() {
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        Recipe found = manager.searchRecipe("Nasi Goreng");
        assertNotNull(found);
        assertEquals("Nasi Goreng", found.getTitle());
    }

    @Test
    @DisplayName("searchRecipe should be case insensitive")
    void searchRecipeShouldBeCaseInsensitive() {
        manager.addRecipe(recipe1);
        Recipe found = manager.searchRecipe("nasi goreng");
        assertNotNull(found);
    }

    @Test
    @DisplayName("searchRecipe should return null for non-existing recipe")
    void searchRecipeShouldReturnNullForNonExisting() {
        manager.addRecipe(recipe1);
        Recipe found = manager.searchRecipe("Bakso");
        assertNull(found);
    }

    // === recommendRecipe Tests ===

    @Test
    @DisplayName("recommendRecipe should return null when empty")
    void recommendRecipeShouldReturnNullWhenEmpty() {
        assertNull(manager.recommendRecipe());
    }

    @Test
    @DisplayName("recommendRecipe should return highest rated recipe")
    void recommendRecipeShouldReturnHighestRated() {
        recipe1.setRating(3.0f);
        recipe2.setRating(5.0f);
        recipe3.setRating(4.0f);
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        manager.addRecipe(recipe3);

        Recipe recommended = manager.recommendRecipe();
        assertNotNull(recommended);
        assertEquals("Sate Ayam", recommended.getTitle());
    }

    @Test
    @DisplayName("recommendRecipe should return null when all ratings are zero")
    void recommendRecipeShouldReturnNullWhenAllZero() {
        manager.addRecipe(recipe1);
        manager.addRecipe(recipe2);
        assertNull(manager.recommendRecipe());
    }

    // === getSavedRecipes Tests ===

    @Test
    @DisplayName("getSavedRecipes should return empty list initially")
    void getSavedRecipesShouldReturnEmptyListInitially() {
        assertTrue(manager.getSavedRecipes().isEmpty());
    }
}
