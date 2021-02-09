package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<MenuItem>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem){
        this.menuItems.add((menuItem));
    }

    public Boolean chooseMenuItem(int idMenuItem){

        if(this.verifyIfMenuItemsListHasTheseMenuItem(idMenuItem) == true)
            return true;

        return false;
    }



    private Boolean verifyIfMenuItemsListHasTheseMenuItem(int idMenuItem){
        if(this.menuItems.stream().filter(menuItem -> menuItem.getId() == idMenuItem).findAny().orElse(null) != null){
            return true;
        }
        return false;
    }

    public void showMenu(){

        System.out.println("\nMenu - Biblioteca \n");
        this.menuItems.forEach(
                (MenuItem menuItem) ->
                        System.out.println(menuItem.getDescription() + " (" + menuItem.getId() + ")"));

        System.out.printf("Choose an option: ");
    }
}
