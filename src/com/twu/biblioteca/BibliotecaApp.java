package com.twu.biblioteca;

import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.MenuItem;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BibliotecaApp {

    private static Menu menu;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        generateMenu();
        menu.showMenu();
        int optionChosen = scanner.nextInt();
    }

    private static void generateMenu(){
        menu = new Menu();
        MenuItem menuItem1 = new MenuItem(1, "List of books");
        menu.addMenuItem(menuItem1);
    }


}
