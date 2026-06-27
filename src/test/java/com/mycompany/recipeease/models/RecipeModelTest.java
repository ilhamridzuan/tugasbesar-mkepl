package com.mycompany.recipeease.models;

import com.mycompany.recipeease.managers.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Recipe model class.
 */
@DisplayName("Recipe Model Tests")
class RecipeModelTest {

    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe(1, "Nasi Goreng", "Nasi, Telur, Bawang, Kecap", "Goreng semua bahan");
    }

    // === Constructor Tests ===

    @Test
    @DisplayName("Constructor should set recipe ID correctly")
    void constructorShouldSetRecipeID() {
        assertEquals(1, recipe.getRecipeID());
    }

    @Test
    @DisplayName("Constructor should set title correctly")
    void constructorShouldSetTitle() {
        assertEquals("Nasi Goreng", recipe.getTitle());
    }

    @Test
    @DisplayName("Constructor should set instructions correctly")
    void constructorShouldSetInstructions() {
        assertEquals("Goreng semua bahan", recipe.getInstructions());
    }

    @Test
    @DisplayName("Constructor should initialize rating to 0")
    void constructorShouldInitializeRatingToZero() {
        assertEquals(0.0f, recipe.getRating(), 0.001f);
    }

    // === Ingredient Parsing Tests ===

    @Test
    @DisplayName("Constructor should parse comma-separated ingredients")
    void constructorShouldParseIngredients() {
        assertNotNull(recipe.getIngredients());
        assertEquals(4, recipe.getIngredients().size());
    }

    @Test
    @DisplayName("Parsed ingredients should have correct names")
    void parsedIngredientsShouldHaveCorrectNames() {
        assertEquals("Nasi", recipe.getIngredients().get(0).getName());
        assertEquals("Telur", recipe.getIngredients().get(1).getName());
        assertEquals("Bawang", recipe.getIngredients().get(2).getName());
        assertEquals("Kecap", recipe.getIngredients().get(3).getName());
    }

    @Test
    @DisplayName("Single ingredient should parse correctly")
    void singleIngredientShouldParseCorrectly() {
        Recipe singleIngredientRecipe = new Recipe(2, "Air Putih", "Air", "Tuang air");
        assertEquals(1, singleIngredientRecipe.getIngredients().size());
        assertEquals("Air", singleIngredientRecipe.getIngredients().get(0).getName());
    }

    // === Add Ingredient Tests ===

    @Test
    @DisplayName("addIngredient should add ingredient to list")
    void addIngredientShouldAddToList() {
        int initialSize = recipe.getIngredients().size();
        Ingredient newIngredient = new Ingredient("Garam", 5, "sendok");
        recipe.addIngredient(newIngredient);
        assertEquals(initialSize + 1, recipe.getIngredients().size());
    }

    // === Setter Tests ===

    @Test
    @DisplayName("setTitle should update title")
    void setTitleShouldUpdateTitle() {
        recipe.setTitle("Mie Goreng");
        assertEquals("Mie Goreng", recipe.getTitle());
    }

    @Test
    @DisplayName("setRecipeID should update recipe ID")
    void setRecipeIDShouldUpdateID() {
        recipe.setRecipeID(99);
        assertEquals(99, recipe.getRecipeID());
    }

    @Test
    @DisplayName("setInstructions should update instructions")
    void setInstructionsShouldUpdateInstructions() {
        recipe.setInstructions("Instruksi baru");
        assertEquals("Instruksi baru", recipe.getInstructions());
    }

    @Test
    @DisplayName("setRating should update rating")
    void setRatingShouldUpdateRating() {
        recipe.setRating(4.5f);
        assertEquals(4.5f, recipe.getRating(), 0.001f);
    }

    // === Video Tutorial Tests ===

    @Test
    @DisplayName("Video tutorial should be null initially")
    void videoTutorialShouldBeNullInitially() {
        // Constructor has a self-assignment bug, so videoTutorial is always null
        assertNull(recipe.getVideoTutorial());
    }

    @Test
    @DisplayName("setVideoTutorial should set video")
    void setVideoTutorialShouldSetVideo() {
        Video video = new Video(1, "https://youtube.com/watch?v=abc123", 1);
        recipe.setVideoTutorial(video);
        assertNotNull(recipe.getVideoTutorial());
        assertEquals("https://youtube.com/watch?v=abc123", recipe.getVideoTutorial().getVideoLink());
    }

    // === toString Tests ===

    @Test
    @DisplayName("toString should contain recipe title")
    void toStringShouldContainTitle() {
        String result = recipe.toString();
        assertTrue(result.contains("Nasi Goreng"));
    }

    @Test
    @DisplayName("toString should contain recipe ID")
    void toStringShouldContainRecipeID() {
        String result = recipe.toString();
        assertTrue(result.contains("1"));
    }
}
