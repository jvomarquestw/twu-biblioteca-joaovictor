package com.twu.biblioteca.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuTest {

    Menu menu;

    @Before
    public void setUp(){
        MenuItem menuItem1 = new MenuItem("List of books", "1");
        MenuItem menuItem2 = new MenuItem("Checkout a book", "2");

        this.menu = new Menu(new Library(new ArrayList<Book>()));
        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
    }

    @Test
    public void shouldChooseAMenuItemAvailableFromMenu(){
        // given

        // when
        String menuChooseActual = menu.chooseMenuItem("1");

        // then
        Assert.assertNotEquals("Please select a valid option!", menuChooseActual);
    }

    @Test
    public void shouldNotChooseAMenuItemNotAvailableFromMenu(){
        // given

        // when
        String menuChooseActual = menu.chooseMenuItem("5");

        // then
        Assert.assertEquals("Please select a valid option!", menuChooseActual);
    }

    @Test
    public void shouldGetContentFromMenu(){
        // given

        // when
        String menuContent = menu.getContent();

        Assert.assertEquals("\nMenu - Biblioteca \n" +
                                    "\n" +
                                    "List of books (1)\n" +
                                    "Checkout a book (2)\n" +
                                    "\n" +
                                    "Choose an option: ", menuContent);

    }

    @Test
    public void shouldAddAMenuItemOnMenu(){
        // given
        MenuItem menuItem3 = new MenuItem("Return a book", "3");

        // when
        menu.addMenuItem(menuItem3);

        // then
        Assert.assertEquals(true, menu.getMenuItems().contains(menuItem3));
    }

    @Test
    public void shouldNotAddARepeatedMenuItemOnMenu(){
        // given
        MenuItem menuItem3 = new MenuItem("Return a book", "3");

        // when
        menu.addMenuItem(menuItem3);
        menu.addMenuItem(menuItem3);
        long numberOfElementsFindEqualsMenuItem3 = menu.getMenuItems().stream().filter(x -> x.equals(menuItem3)).count();

        // then
        Assert.assertEquals(1, numberOfElementsFindEqualsMenuItem3);
    }


}
