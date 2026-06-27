package com.mycompany.recipeease;


import com.mycompany.recipeease.models.Rating;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deswi
 */
public class RatingTest {
    public static void main(String[] args) {

        Rating rating1 = new Rating(1, 4.5f, "John Doe", "Spaghetti Bolognese");
        Rating rating2 = new Rating(2, 5.0f, "Jane Smith", "Chicken Curry");

        System.out.println("Recipe: " + rating1.getRecipeTitle() + ", Score: " + rating1.getScore());
        System.out.println("Recipe: " + rating2.getRecipeTitle() + ", Score: " + rating2.getScore());
    }

}
