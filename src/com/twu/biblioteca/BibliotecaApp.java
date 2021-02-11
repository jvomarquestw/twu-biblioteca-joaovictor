package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.MenuItem;
import com.twu.biblioteca.helper.Message;
import com.twu.biblioteca.helper.Util;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static Menu menu;
    private static Library library;

    public static void main(String[] args) {

        System.out.println(Message.WELCOME);

        library = new Library(generateDefaultBookList());

        generateMenu();

        System.out.println(menu.getContent());

        String returnChooseMenuItem = menu.chooseMenuItem(Util.readInput());
        System.out.println(returnChooseMenuItem);

        while(returnChooseMenuItem != Message.QUIT){
            System.out.println(menu.getContent());
            returnChooseMenuItem = menu.chooseMenuItem(Util.readInput());
            System.out.println(returnChooseMenuItem);
        }

    }

    private static List<Book> generateDefaultBookList(){
        Book book1 = new Book("1", "Book 1", "Joao", 1996);
        Book book2 = new Book("2", "Book 2", "Lucas", 1993);
        Book book3 = new Book("3", "Book 3", "Jamille", 1996);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        return bookList;
    }

    private static void generateMenu(){
        menu = new Menu(library);

        MenuItem menuItem1 = new MenuItem("List of books", "1");
        MenuItem menuItem2 = new MenuItem("Checkout a book", "2");
        MenuItem menuItem3 = new MenuItem("Return a book", "3");
        MenuItem menuItem4 = new MenuItem("Quit application", "0");

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);
        menu.addMenuItem(menuItem4);
    }


}
