package com.twu.biblioteca.domain;

import com.twu.biblioteca.helper.Message;
import com.twu.biblioteca.helper.Util;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getAllBooksInStringFormat(){
        StringBuilder booksPrinted = new StringBuilder();
        this.books.forEach(book -> booksPrinted.append(book.toString()));
        return booksPrinted.toString();
    }

    public String getAvailableBooksInStringFormat(){
        StringBuilder booksPrinted = new StringBuilder();
        this.books.forEach(book -> {
                    if(book.getAvailable() == true)
                        booksPrinted.append(book.toString());
                }
        );

        return booksPrinted.toString();
    }

    public String getNotAvailableBooksInStringFormat(){
        StringBuilder booksPrinted = new StringBuilder();
        this.books.forEach(book -> {
                    if(book.getAvailable() == false)
                        booksPrinted.append(book.toString());
                }
        );

        return booksPrinted.toString();
    }

    public String checkoutABook(){

        String showAvailableBooks = this.getAvailableBooksInStringFormat();
        if(showAvailableBooks.isEmpty())
            return Message.BOOK_AVAILABLE_LIST_IS_EMPTY;

        System.out.println(showAvailableBooks);
        System.out.printf("Choose a book to checkout: ");

        String bookId = Util.readInput();
        Book bookChosen = this.findBookById(bookId);

        if(bookChosen != null)
            return bookChosen.checkout();
        else
            return Message.CHECKOUT_UNSUCCESSFUL;
    }

    public String returnABook(){
        String showNotAvailableBooks = this.getNotAvailableBooksInStringFormat();

        if(showNotAvailableBooks.isEmpty())
            return Message.BOOK_NOT_AVAILABLE_LIST_IS_EMPTY;

        System.out.println(showNotAvailableBooks);
        System.out.printf("Choose a book to return: ");

        String bookId = Util.readInput();
        Book bookChosen = this.findBookById(bookId);

        if(bookChosen != null)
            return bookChosen.returnToLibrary();

        return Message.RETURN_UNSUCCESSFUL;
    }

    private Book findBookById(String bookId){
        return this.books.stream().filter(book -> book.getId().equals(bookId)).findAny().orElse(null);
    }


}
