package com.twu.biblioteca.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {

    private Library library;

    @Test
    public void shouldPrintEmptyStringWhenBookListAvailableIsEmpty(){
        //given
        library = new Library(new ArrayList<Book>());

        //when
        String returnShowAvailableBooks = library.getAvailableBooksInStringFormat();

        //than
        Assert.assertEquals("", returnShowAvailableBooks);
    }

    @Test
    public void shouldPrintEmptyStringWhenBookListNotAvailableIsEmpty(){
        //given
        library = new Library(new ArrayList<Book>());

        //when
        String returnShowNotAvailableBooks = library.getNotAvailableBooksInStringFormat();

        //than
        Assert.assertEquals("", returnShowNotAvailableBooks);
    }

    @Test
    public void shouldReturnAllBooksInStringFormat(){
        // given
        Book book1 = new Book("1", "Book 1", "Joao", 1996);
        Book book2 = new Book("2", "Book 2", "Lucas", 1993);
        Book book3 = new Book("3", "Book 3", "Jamille", 1996);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        library = new Library(bookList);

        // when
        String allBooksInStringFormat = library.getAllBooksInStringFormat();

        // that
        Assert.assertEquals("Book 1 | Author: Joao | Year Published: 1996 (1)\n" +
                                     "Book 2 | Author: Lucas | Year Published: 1993 (2)\n" +
                                     "Book 3 | Author: Jamille | Year Published: 1996 (3)\n", allBooksInStringFormat);
    }
}
