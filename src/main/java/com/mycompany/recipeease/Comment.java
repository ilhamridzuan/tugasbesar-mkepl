/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recipeease;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author deswi
 */
public class Comment {
    private int commentID;
    private String content;
    private String author;
    private LocalDateTime timestamp;

    public Comment(int commentID, String content, String author, Date date) {
        this.commentID = commentID;
        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }

    public int getCommentID() {
        return commentID;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void editComment(String newContent) {
        this.content = newContent;
        this.timestamp = LocalDateTime.now();
    }

    public void deleteComment() {
        this.content = "This comment has been deleted.";
        this.timestamp = LocalDateTime.now();
    }

    int getRecipeID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

