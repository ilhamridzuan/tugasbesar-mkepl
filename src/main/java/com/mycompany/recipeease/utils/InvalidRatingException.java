/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.utils;

/**
 * Custom exception to handle invalid rating scenarios.
 * @author deswi
 */
public class InvalidRatingException extends Exception {
    
    public InvalidRatingException(String message) {
        super(message);
    }

    public InvalidRatingException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidRatingException(Throwable cause) {
        super(cause);
    }
}

