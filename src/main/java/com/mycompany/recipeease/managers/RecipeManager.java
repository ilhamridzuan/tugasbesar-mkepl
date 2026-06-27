/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.managers;

/**
 *
 * @author
 */

import com.mycompany.recipeease.models.Recipe;
import java.util.ArrayList;

public class RecipeManager {
    private ArrayList<Recipe> savedRecipes;

    public RecipeManager() {
        savedRecipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        savedRecipes.add(recipe);
    }

    public void deleteRecipe(int recipeID) {
        savedRecipes.removeIf(recipe -> recipe.getRecipeID() == recipeID);
    }

    public Recipe searchRecipe(String title) {
        for (Recipe recipe : savedRecipes) {
            if (recipe.getTitle().equalsIgnoreCase(title)) {
                return recipe;
            }
        }
        return null;
    }

    public Recipe recommendRecipe() {
        Recipe bestRecipe = null;
        float highestRating = 0;
        for (Recipe recipe : savedRecipes) {
            if (recipe.getRating() > highestRating) {
                highestRating = recipe.getRating();
                bestRecipe = recipe;
            }
        }
        return bestRecipe;
    }

    public ArrayList<Recipe> getSavedRecipes() {
        return savedRecipes;
    }
}


