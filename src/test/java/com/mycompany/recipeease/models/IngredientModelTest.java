package com.mycompany.recipeease.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Ingredient model class.
 */
@DisplayName("Ingredient Model Tests")
class IngredientModelTest 

    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient("Garam", 1, "sendok");
    }

    // === Constructor & Getter Tests ===

    @Test
    @DisplayName("Constructor should set name correctly")
    void constructorShouldSetName() {
        assertEquals("Garam", ingredient.getName());
    }

    @Test
    @DisplayName("Constructor should set ingredient ID correctly")
    void constructorShouldSetIngredientID() {
        assertEquals(1, ingredient.getIngredientID());
    }

    @Test
    @DisplayName("Constructor should set unit correctly")
    void constructorShouldSetUnit() {
        assertEquals("sendok", ingredient.getUnit());
    }

    // === Setter Tests ===

    @Test
    @DisplayName("setName should update name")
    void setNameShouldUpdateName() {
        ingredient.setName("Gula");
        assertEquals("Gula", ingredient.getName());
    }

    @Test
    @DisplayName("setIngredientID should update ID")
    void setIngredientIDShouldUpdateID() {
        ingredient.setIngredientID(99);
        assertEquals(99, ingredient.getIngredientID());
    }

    @Test
    @DisplayName("setQuantity should update quantity")
    void setQuantityShouldUpdateQuantity() {
        ingredient.setQuantity(2.5);
        assertEquals(2.5, ingredient.getQuantity(), 0.001);
    }

    @Test
    @DisplayName("setUnit should update unit")
    void setUnitShouldUpdateUnit() {
        ingredient.setUnit("gram");
        assertEquals("gram", ingredient.getUnit());
    }

    // === toString Tests ===

    @Test
    @DisplayName("toString should return ingredient name")
    void toStringShouldReturnName() {
        assertEquals("Garam", ingredient.toString());
    }

    // === Edge Cases ===

    @Test
    @DisplayName("Ingredient with empty name should be created")
    void ingredientWithEmptyNameShouldBeCreated() {
        Ingredient emptyIngredient = new Ingredient("", 0, "");
        assertEquals("", emptyIngredient.getName());
    }
}
