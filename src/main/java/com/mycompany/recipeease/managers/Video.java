/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.managers;

/**
 *
 * @author pistachya
 */
public class Video {
    
    private int videoID;
    private String videoLink;
    private int recipeID;

    public Video(int videoID, String videoLink, int recipeID) {
        this.videoID = videoID;
        this.videoLink = videoLink;
        this.recipeID = recipeID;
    }

    public int getVideoID() {
        return videoID;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public String toString() {
        return videoID + "VideoID : " + recipeID + "RecipeID : " + videoLink + "Link Video : ";
    }
 
}
