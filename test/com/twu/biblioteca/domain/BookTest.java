package com.twu.biblioteca.domain;

import com.twu.biblioteca.helper.Message;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {


    @Test
    public void shouldReturnSuccessfulMessageWhenTryCheckoutABookAvailable(){
        // given
        Book book = new Book("1", "Book 1", "Joao", 1996);

        // when
        String bookCheckoutActual = book.checkout();

        // then
        Assert.assertEquals(Message.CHECKOUT_SUCCESSFUL, bookCheckoutActual);
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenTryCheckoutABookNotAvailable(){
        // given
        Book book = new Book("1", "Book 1", "Joao", 1996);
        book.checkout();

        // when
        String bookCheckoutActual = book.checkout();

        // then
        Assert.assertEquals(Message.CHECKOUT_UNSUCCESSFUL, bookCheckoutActual);
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTryReturnABookThatWasCheckout(){
        // given
        Book book = new Book("1", "Book 1", "Joao", 1996);

        // when
        book.checkout();
        String bookReturnActual = book.returnToLibrary();

        // then
        Assert.assertEquals(Message.RETURN_SUCCESSFUL, bookReturnActual);
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenTryReturnABookThatWasNotCheckout(){
        // given
        Book book = new Book("1", "Book 1", "Joao", 1996);

        // when
        String bookReturnActual = book.returnToLibrary();

        // then
        Assert.assertEquals(Message.RETURN_UNSUCCESSFUL, bookReturnActual);
    }

    @Test
    public void shouldPrintABook(){
        // given
        Book book = new Book("1", "Book 1", "Joao", 1996);

        // than
        String bookPrinted = book.toString();

        // that
        Assert.assertEquals("Book 1 | Author: Joao | Year Published: 1996 (1)\n", bookPrinted);
    }

}
