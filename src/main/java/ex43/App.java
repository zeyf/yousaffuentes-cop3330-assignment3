package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */


/*
* PSEUDOCODE
*
* CREATE NEW INSTANCE OF WEBSITE GENERATOR
* CALL THE PROCESSWEBSITE CREATION FUNCTION TO ASK FOR WHAT TO GENERATE AND DATA
* FOR FILES AND GEN FILES/FOLDERS
*
*
* */


public class App {

    public static void main (String[] args) {
        WebsiteGenerator webGenerator = new WebsiteGenerator();
        webGenerator.processWebsiteCreation();
    };

}
