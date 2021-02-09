package com.twu.biblioteca.domain;

import com.sun.jdi.connect.Connector;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldCheckoutABookIfAvailable(){
        // given
        Book book = new Book();

        // when
        Boolean bookCheckoutActual = book.checkout();

        // then
        Assert.assertEquals(true, bookCheckoutActual);
    }

}
