package com.twu.biblioteca.domain;

public class MenuItem {

    private int id;
    private String description;

    public MenuItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
