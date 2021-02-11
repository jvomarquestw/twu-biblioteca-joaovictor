package com.twu.biblioteca.domain;

import com.twu.biblioteca.helper.Message;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuItem> menuItems;

    private Library library;

    public Menu(Library library) {
        this.library = library;
        this.menuItems = new ArrayList<MenuItem>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem){
        if(isMenuItemOnMenu(menuItem) == false)
            this.menuItems.add((menuItem));
    }

    private Boolean isMenuItemOnMenu(MenuItem menuItem){
        if(this.menuItems.stream().filter(x -> x.equals(menuItem)).findAny().orElse(null) != null)
            return true;

        return false;
    }

    public String chooseMenuItem(String idMenuItem){

        switch (idMenuItem){
            case "1":
                String allBooks = this.library.getAllBooksInStringFormat();
                return allBooks;
            case "2":
                String checkout = this.library.checkoutABook();
                return checkout;
            case "3":
                String returnABook = this.library.returnABook();
                return returnABook;
            case "0":
                return Message.QUIT;
            default:
                return "Please select a valid option!";
        }

    }

    public String getContent(){

        StringBuilder menuContent = new StringBuilder();
        menuContent.append("\nMenu - Biblioteca \n");
        this.menuItems.forEach(
                (MenuItem menuItem) -> menuContent.append("\n" + menuItem.getTitle() + " (" + menuItem.getSelector() + ")"));

        menuContent.append("\n\nChoose an option: ");

        return menuContent.toString();
    }


}
