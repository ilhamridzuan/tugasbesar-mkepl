/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease;

import com.mycompany.recipeease.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Administrator extends User{
    private List<String> comments;
    private List<String> users;
    private List<String> nutritions;

    public Administrator(int userID, String username, String password, String email, String role) {
        super(userID, username, password, email, role);
        this.comments = new ArrayList<>();
        this.users = new ArrayList<>();
        this.nutritions = new ArrayList<>();
    }
    
    //// Metode untuk mengelola komentar di menu admin
    public void manageComments(String action, String comment) {
        switch (action.toLowerCase()) {
            case "tambah":
                comments.add(comment);
                System.out.println("Komentar yang ditambahkan: " + comment);
                break;
            case "hapus":
                if (comments.remove(comment)) {
                    System.out.println("Komentar yang dihapus: " + comment);
                } else {
                    System.out.println("Komentar tidak ditemukan: " + comment);
                }
                break;
            case "lihat":
                System.out.println("Semua komentar: ");
                for (String c : comments) {
                    System.out.println("- " + c);
                }
                break;
            default:
                System.out.println("Tindakan yang tidak valid bagi komentar: " + action);
        }
    }
    //// Metode untuk mengelola user di menu admin
    public void manageUsers(String action, String user) {
        switch (action.toLowerCase()) {
            case "tambah":
                users.add(user);
                System.out.println("Pengguna yang ditambahkan: " + user);
                break;
            case "blokir":
                if (users.contains(user)) {
                    System.out.println("Pengguna yang diblokir: " + user);
                } else {
                    System.out.println("Pengguna tidak ditemukan: " + user);
                }
                break;
            case "lihat":
                System.out.println("Semua pengguna: ");
                for (String u : users) {
                    System.out.println("- " + u);
                }
                break;
            default:
                System.out.println("Tindakan yang tidak valid bagi Pengguna: " + action);
        }
    }
}

