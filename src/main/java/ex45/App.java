package ex45;


/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.PrintWriter;

/*
*
* PSEUDO CODE FOR MAIN APP:
*
* CREATE A NEW FILE THAT SETS A POINTER TO THE PREMADE INPUT FILE
* INITIALIZE THE STRING REPLCAER WITH WHAT TERMS WE WANT TO FIND AND WHAT WE WANT TO REPLACE IT WITH
* HAVE A TRY CATCH WITH:
*   - SCANNER THAT SCANS THE INPUT FILE
*       - WHILE THERES MORE LINES, CALL THE REPLACER TO USE REGEX TO REPLACE ALL INSTANCES IN A SINGLE LINE
*         OF THE WORD TO FIND WITH THE WORD TO REPLACEE BASED ON THE INPUT FROM THE SCANNER OF FILE
*         THIS BUILDS THE NEW OUTPUT TO THE STRING
*   - HANDLE AND PRINT THE CATCH EXCEPTION
*
* WITH A TRY CATCH:
*
*   - UTILIZE A PRINT WRITER AFTER REPLACING AND BUILDING NEW OUTPUT TO PRINT OUT TO A
*   - NEW FILE (THE OUTPUT FILE) WITH REPLACED STRING
*   - PRINT OUT THE NEW OUTPUT TO THE NEW OUTPUT FILE
*   - CLOSE THE WRITER POINTER TO THE NEW OUTPUT FILE
*   - CATCH THE EXCEPTION AND PRINT IT.
*
*
* */

public class App {

    public static void main (String[] args) {
        File file = new File("src/main/java/ex45/exercise45_input.txt");
        StringReplacer replacer = new StringReplacer("utilize", "use");
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine())
                replacer.replaceTermInLine(s.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println(String.format("%s\n%s\n", "Please enter a valid, existing file name.", e));
        };

        try {
            Scanner s2 = new Scanner(System.in);
            System.out.print("Enter the output name you want: ");
            String opfilename = s2.nextLine();
            PrintWriter writer = new PrintWriter("src/main/java/ex45/" + opfilename, "UTF-8");
            writer.print(replacer.getNewOutput());
            writer.close();
        } catch (Exception ex) {
            System.out.println(String.format("%s\n%s\n", "Please enter a valid, existing file name.", ex));
        };
    };

}
