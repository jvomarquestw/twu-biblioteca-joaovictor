package com.twu.biblioteca.helper;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(new InputStreamReader(System.in));

    public static String readInput(){
        String inputUser = scanner.next();
        return inputUser;
    }
}
