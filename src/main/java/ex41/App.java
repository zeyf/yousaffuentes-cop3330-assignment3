package ex41;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

/*
*
* WE MAKE AN INSTANCE OF THE DATA SORTER THAT READS IN DATA FROM THE FILE
* SORTS THE DATA, AND THEN PRINTS IT TO AN OUTPUT FILE
*
*
* */

import java.io.File;

public class App {

    public static void main (String [] args) {

        File file = new File("src/main/java/ex41/exercise41_input.txt");
        dataSorter sorter = new dataSorter(file);
        sorter.collectAndSortNames();
        sorter.printNamesToFile();
    }

}
