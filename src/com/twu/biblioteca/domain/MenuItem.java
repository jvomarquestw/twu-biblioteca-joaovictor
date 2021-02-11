package com.twu.biblioteca.domain;

import java.util.List;

public class MenuItem {

    private String title;
    private String selector;

    public MenuItem(String title, String selector) {
        this.title = title;
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }

    public String getTitle() {
        return title;
    }

}
