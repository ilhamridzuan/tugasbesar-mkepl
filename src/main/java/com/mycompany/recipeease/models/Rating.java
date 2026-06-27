/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.models;

/**
 *
 * @author deswi
 */
public class Rating {
    private int ratingID;
    private float score;
    private String user;
    private String recipe;

    public Rating(int ratingID, float score, String user, String recipe) {
        this.ratingID = ratingID;
        this.score = score;
        this.user = user;
        this.recipe = recipe;
    }

    public int getRatingID() {
        return ratingID;
    }

    public float getScore() {
        return score;
    }

    public String getUser() {
        return user;
    }

    public String getRecipe() {
        return recipe;
    }
    public void setRating(float newScore) {
        this.score = newScore;
    }

    public String getRecipeTitle() {
        return recipe; 
    }
}

