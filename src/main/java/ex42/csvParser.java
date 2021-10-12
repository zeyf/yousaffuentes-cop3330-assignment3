package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


/*
* PSEUDO CODE
*
* TAKE IN A FILE NAME PATH
* INITIALIZE THE SCANNER TO THE FILE AS INPUT
*
* WHEN PROCESS CSV IS CALLED, WE PRINT THE HEAD OF THE TABLE (LABELS AND HEADER LINE)
* ALONG WITH THE SUBSEQUENT LINES AS WE PROCESS THE CSV FILE
*
* */

public class csvParser {

    private Scanner s;
    private File file;

    csvParser(String fileName) {
        initScanner(fileName);
    };

    private void initScanner(String fileName) {
        file = new File(fileName);
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        };
    };

    private void printRow(String[] splitLine) {
        String base = "";
        for (int x = 0; x < splitLine.length; x++)
                base += splitLine[x] + " ";
        System.out.print(base + "\n");
    };

    public void processCSV() {
        printTableHead();
        while (s.hasNextLine()) {
            String[] splitLine = s.nextLine().split(",");
            printRow(splitLine);
        };
    };

    private void printTableHead() {
        System.out.println("Last\tFirst\tSalary");
        System.out.println("----------------------");
    };



}
