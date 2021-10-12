package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

/*
* PSEUDOCODE:
*
* THE DATASORTER TAKES IN A FILE TO TAKE INPUT AS PARAMETER FOR INSTANTIATION
*
* IT INITIALIZES A SCANNER TO THE FILE AS INPUT
*
* IT COLLECSTS THE NAME FROM THE FILE BY LINE AND THEN CALLS ORT NAMES
*
* SORT NAMES USES COLLECTIONS TO SORT THE NAMES IN THE ARRAY LIST
*
* THEN WE CALL PRINTNAMES TO FILE THAT TRY CATCHES MAKING A WRITER TO WRITE THE OUTPUT
* TO AN OUTPUT FILE
*
* */

public class dataSorter {

    private Scanner s;
    private ArrayList<String> names = new ArrayList<String>();

    dataSorter(File file) {
        initScanner(file);
    };

    private void initScanner(File file) {
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        };
    };

    public void collectAndSortNames() {
        while (s.hasNextLine())
            names.add(s.nextLine());
        sortNames();
    };

    private void sortNames() {
        Collections.sort(names);
    };

    public void printNamesToFile() {

        try {
            PrintWriter writer = new PrintWriter("src/main/java/ex41/exercise41_output.txt", "UTF-8");
            writer.print(String.format("Total of %d names\n-----------------\n", names.size()));
            for (int x = 0; x < names.size(); x++)
                writer.print(String.format("%s\n", names.get(x)));
            writer.close();
        } catch (Exception ex) {
            System.out.println(String.format("%s\n%s\n", "Please enter a valid, existing file name.", ex));
        };
    }





}
