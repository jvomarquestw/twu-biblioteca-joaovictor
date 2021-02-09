package com.twu.biblioteca.domain;

public class Book {

    private int id;
    private String isbn;
    private String author;
    private int yearPublished;
    private Boolean available;

    public Book(){
        this.available = true;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean checkout(){

        if(this.available == true){
            this.available = false;
            return true;
        }

        return false;
    }
}
