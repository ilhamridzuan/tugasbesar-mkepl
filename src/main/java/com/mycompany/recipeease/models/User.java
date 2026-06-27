/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease.models;

/**
 *
 * @author pistachya
 */
public class User {
    private int userID;
    String username;
    private String password;
    private String email;
    private String role;

    public User(int userID, String username, String password, String email, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void register() {
        System.out.println(username + "Terdaftar.");
    }
    public void login() {
        System.out.println(username + "Masuk.");
    }
    public void viewRecipe() {
        System.out.println(username + "Melihat resep.");
    }
    public void rateRecipe() {
        System.out.println(username + "Penilaian resep.");
    }
    public void addComment() {
        System.out.println(username + "Menambahkan komentar.");
    }
}
