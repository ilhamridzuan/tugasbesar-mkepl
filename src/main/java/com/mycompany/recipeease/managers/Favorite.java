/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.managers;

/**
 *
 * @author pistachya
 */
import com.mycompany.recipeease.models.User;
import com.mycompany.recipeease.models.Recipe;
import java.util.ArrayList;
import java.util.List;

public class Favorite {
    private User user;
    private List<Recipe> favoriteRecipes;

    public Favorite(User user) {
        this.user = user;
        this.favoriteRecipes = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public List<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public void addFavoriteRecipe(Recipe recipe) {
        if (!favoriteRecipes.contains(recipe)) {
            favoriteRecipes.add(recipe);
            System.out.println("Recipe added to favorites: " + recipe.getTitle());
        } else {
            System.out.println("Recipe is already in favorites.");
        }
    }

    public void removeFavoriteRecipe(Recipe recipe) {
        if (favoriteRecipes.contains(recipe)) {
            favoriteRecipes.remove(recipe);
            System.out.println("Recipe removed from favorites: " + recipe.getTitle());
        } else {
            System.out.println("Recipe is not in favorites.");
        }
    }

    public void viewFavoriteRecipes() {
        System.out.println("\n--- Favorite Recipes for User: " + user.getUsername() + " ---");
        if (favoriteRecipes.isEmpty()) {
            System.out.println("No favorite recipes.");
        } else {
            for (Recipe recipe : favoriteRecipes) {
                System.out.println(recipe);
            }
        }
    }
}
