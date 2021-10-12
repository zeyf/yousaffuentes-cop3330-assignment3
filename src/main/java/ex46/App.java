package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*
* PSEUDOCODE:
*
* CONSIDERING THAT THIS PROGRAM INVOLVES READING FILE INPUT AND TAKING COUNT OF STRINGS,
* A "STRING COLLECTOR" CLASS THAT COLLECTS ALL NON-EXISTENT, UNIQUE STRINGS IN A COLLECTION (LIKE AN ARRAYLIST)
* AND IF A STRING ALREADY IS EXISTENT IN A COLLECTION, THEN JUST INCREMENT THE PARALLEL FREQUENCY COUNTER ARRAYLIST
*

*
*
* THE MAIN APP:
*
* Create file
* Initialize the string collector
* Try scanning the file with a envoloping try catch to catch error FileNotFoundException
* Read until theres no more lines in the file
* split each line by spaces to get just words
* for all words in split string array check if it exists in array list of strings in string collector
* if it doesnt exist, add it in to string list and then set the counter of it to 1
* if does exist just increment at index respective of string in string list in frequency counter list
* set completion of stirng collection to true
* build and print the results of collection from file
* catch any file not found exception
*
*
*
* */

public class App {

    public static void main (String[] args) {
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        StringCollector collector = new StringCollector();
        try {

            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] splitLine = line.split(" ");
                for (String str: splitLine) {
                    if (collector.linearSearchForString(str) == false)
                        collector.addNewString(str);
                };
            };

            collector.setStringsCollectedCompletionStatus(true);
            System.out.println(collector.buildCollectionResults());

        } catch (FileNotFoundException e) {
            System.out.println("Please enter a valid, existing file name.");
        };

    };


}