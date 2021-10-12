package ex44;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

import java.util.Scanner;

public class App {

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        JsonFileParser parser = new JsonFileParser("src/main/java/ex44/exercise44_input.json");
        while (parser.getProductFoundStatus() == false) {
            System.out.print("What is the product name? ");
            parser.searchHandlerOfProductsArray(s.nextLine());
        }
    }

}
