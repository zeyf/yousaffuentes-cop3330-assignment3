package ex42;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */


/*
* PSEUDOCODE
*
* MAKE A PARSER OF CSV TEXT FILE THAT ARE COMMA DELIMITED
* CALL THE PROCESS CSV function
*
* */

public class App {

    public static void main (String[] args) {
        csvParser parser = new csvParser("src/main/java/ex42/exercise42_input.txt");
        parser.processCSV();
    };

}
