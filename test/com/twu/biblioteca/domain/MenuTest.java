package com.twu.biblioteca.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {

    @Test
    public void shouldChooseAMenuItemAvailableFromMenu(){
        // given
        MenuItem menuItem1 = new MenuItem(1, "List of books");
        MenuItem menuItem2 = new MenuItem(2, "List of movies");

        Menu menu = new Menu();
        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        // when
        Boolean menuChooseActual = menu.chooseMenuItem(1);

        // then
        Assert.assertEquals(true, menuChooseActual);
    }

    @Test
    public void shouldNotChooseAMenuItemNotAvailableFromMenu(){
        // given
        MenuItem menuItem1 = new MenuItem(1, "List of books");
        MenuItem menuItem2 = new MenuItem(2, "List of movies");

        Menu menu = new Menu();
        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        // when
        Boolean menuChooseActual = menu.chooseMenuItem(3);

        // then
        Assert.assertEquals(false, menuChooseActual);
    }

}
