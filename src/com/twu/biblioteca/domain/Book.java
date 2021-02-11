package com.twu.biblioteca.domain;

import com.twu.biblioteca.helper.Message;

public class Book {

    private String id;
    private String title;
    private String author;
    private int yearPublished;
    private Boolean available;

    public Book(String id, String title, String author, int yearPublished){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public String checkout(){

        if(this.available == true){
            this.available = false;
            return Message.CHECKOUT_SUCCESSFUL;
        }

        return Message.CHECKOUT_UNSUCCESSFUL;
    }

    public String returnToLibrary(){

        if(this.available == false){
            this.available = true;
            return Message.RETURN_SUCCESSFUL;
        }

        return Message.RETURN_UNSUCCESSFUL;
    }

    @Override
    public String toString() {
        return title + " | Author: " + this.author + " | Year Published: " + this.yearPublished + " (" + this.id + ")\n";
    }

}
