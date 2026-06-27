package com.mycompany.recipeease.managers;

import com.mycompany.recipeease.Comment;
import com.mycompany.recipeease.CommunityOperations;
import com.mycompany.recipeease.utils.InvalidRatingException;
import com.mycompany.recipeease.models.Rating;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deswi
 */



public class Community implements CommunityOperations {
    private final List<Comment> comments;
    private int likes;
    private final List<Rating> ratings;
    private int recipeID;

    public Community() {
        this.comments = new ArrayList<>();
        this.likes = 0;
        this.ratings = new ArrayList<>();
        this.recipeID = recipeID;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void addLike() {
        likes++;
    }

    @Override
    public void addRating(Rating rating) throws InvalidRatingException{
        ratings.add(rating);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public int getLikes() {
        return likes;
    }

    @Override
    public List<Rating> getRatings() {
        return ratings;
    }

    // Optional methods for additional features
    public void resetLikes() {
        this.likes = 0;
    }

    public void clearComments() {
        comments.clear();
    }
    
    public int getRecipeID() {
        return recipeID;
    }
    
    //Hitung rata-rata penilaian per resep(seluruh resep)
    @Override
    public Map<String, Float> getAverageRatingByRecipe() {
        Map<String, Float> averages = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Rating rating : ratings) {
            averages.put((String) rating.getRecipeTitle(), averages.getOrDefault(rating.getRecipeTitle(), 0f) + rating.getScore());
            counts.put((String) rating.getRecipeTitle(), counts.getOrDefault(rating.getRecipeTitle(), 0) + 1);
        }

        for (String recipe : averages.keySet()) {
            averages.put(recipe, averages.get(recipe) / counts.get(recipe));
        }

        return averages;
    }
    
    // Hitung rata-rata penilaian untuk resep tertentu
    public float calculateAverageRatingForRecipe(String title) {
        float totalRating = 0.0f;
        int count = 0;

        for (Rating rating : ratings) {
            if (rating.getRecipeTitle().equalsIgnoreCase(title)) {
                totalRating += rating.getScore();
                count++;
            }
        }

        if (count == 0) {
            return 0.0f; 
        }

        return totalRating / count;
    }
}

