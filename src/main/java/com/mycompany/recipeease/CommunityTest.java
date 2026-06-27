/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease;

import com.mycompany.recipeease.managers.Community;
import com.mycompany.recipeease.utils.InvalidRatingException;
import com.mycompany.recipeease.models.Rating;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author deswi
 */
public class CommunityTest {
    public static void main(String[] args) {
        try {
            Community community = new Community();

            Comment comment1 = new Comment(1, "Resep yang mudah untuk dipraktikan!", "User1", new Date());
            Comment comment2 = new Comment(2, "Adonannya sedikit terlalu lembek, jadi saya harus menambahkan tepung. ", "User2", new Date());

            community.addComment(comment1);
            community.addComment(comment2);

            community.addLike();

            Rating rating1 = new Rating(1, 4.5f, "User1", "Pasta");
            Rating rating2 = new Rating(2, 3.8f, "User2", "Cookies");
            Rating rating3 = new Rating(3, 5.0f, "User3", "Pizza");

            community.addRating(rating1);
            community.addRating(rating2);
            community.addRating(rating3);

            System.out.println("Comments:");
            for (Comment comment : community.getComments()) {
                System.out.println(comment.getAuthor() + ": " + comment.getContent());
            }

            System.out.println("Likes: " + community.getLikes());

            System.out.println("Average Ratings by Recipe:");
            for (Map.Entry<String, Float> entry : community.getAverageRatingByRecipe().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (InvalidRatingException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

