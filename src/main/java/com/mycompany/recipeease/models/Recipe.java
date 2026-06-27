/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.models;

import com.mycompany.recipeease.managers.Video;
import java.util.ArrayList;
/**
 *
 * @author deswi
 */

public class Recipe {
    private int recipeID;
    private String title;
    private ArrayList<Ingredient> ingredients;
    private String instructions;
    private Video videoTutorial;
    private float rating;

    public Recipe(int recipeID, String title, String ingredients, String instructions) {
    this.recipeID = recipeID;
    this.title = title;
    this.ingredients = new ArrayList<>();

    String[] ingredientList = ingredients.split(",");
    for (String ingredient : ingredientList) {
        String trimmedIngredient = ingredient.trim();
        this.ingredients.add(new Ingredient(trimmedIngredient, 0, "unit")); // Default quantity & unit
    }
    
    this.instructions = instructions;
    this.videoTutorial = videoTutorial;
    this.rating = 0.0f;
}

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    public void setVideoTutorial(Video videoTutorial) {
        this.videoTutorial = videoTutorial;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Video getVideoTutorial() {
        return videoTutorial;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Recipe ID: " + recipeID + 
               "\nTitle: " + title +
               "\nIngredients: " + ingredients + 
               "\nInstructions: " + instructions +
               "\nVideo Link: " + (videoTutorial != null ? videoTutorial : "No video link available") + "\n";
    }
}


