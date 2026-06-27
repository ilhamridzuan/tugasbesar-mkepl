/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.recipeease;
import com.mycompany.recipeease.utils.InvalidRatingException;
import com.mycompany.recipeease.models.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author deswi
 */
public interface CommunityOperations {
    void addComment(Comment comment);
    void addLike();
    void addRating(Rating rating) throws InvalidRatingException;
    List<Comment> getComments();
    int getLikes();
    List<Rating> getRatings();
    Map<String, Float> getAverageRatingByRecipe();
}
