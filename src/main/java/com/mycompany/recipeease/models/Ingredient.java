/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.models;

/**
 *
 * @author fadli
 */
public class Ingredient {
    private int ingredientID;
    private String name;
    private double quantity;
    private String unit;

    public Ingredient(String name, int ingredientID, String unit) {
        this.ingredientID = ingredientID;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    @Override
    public String toString() {
        return name;
    }
}

