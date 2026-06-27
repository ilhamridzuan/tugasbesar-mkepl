/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease;

import com.mycompany.recipeease.models.User;

/**
 *
 * @author 
 */
public class RecipeHunter extends User {
    private String searchPreferences;

    public RecipeHunter(int userID, String username, String password, String email, String role, String searchPreferences) {
        super(userID, username, password, email, role);
        this.searchPreferences = searchPreferences;
    }

    public String getSearchPreferences() {
        return searchPreferences;
    }
    public void setSearchPreferences(String searchPreferences) {
        this.searchPreferences = searchPreferences;
    }

    public void searchRecipe() {
        // Kodingan untuk mencari resep berdasarkan keinginan
    }
    public void saveRecipe() {
        // Kodingan untuk menyimpan resep yang disukai
    }
}

