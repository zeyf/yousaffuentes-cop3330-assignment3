package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */


/*
*
* PSEUDOCODE:
*
* HAVE THE DEFAULT CWD PATH, INIT THE SCANNER
*
* TAKE IN NAME OF WEBSITE
* TAKE IN NAME OF AUTHOR
*
*
* THEN WE ASK WHAT FOLDERS TO GENERATE
*  - JAVASCRIPT FOLDER
*  - CSS FOLDER
*
* THEN BASED ON WHAT THE USER WANTS TO GENERATE, GENERATE THOSE FOLDERS IN SUB FOLDERS OF THE WEBSITE
* WITH PROPER ERROR HANDLING WITH TRY CATCH
* WRITE OUT TO INDEX HTML WITH THE TITLE TAG COMMENT AS THE NAME OF SITE AND THE META AUTHOR AS THE AUTHOR
*
* PRINT OUT WHATS BEING MADE AND CREATED
*
* */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class WebsiteGenerator {

    private Scanner s;
    private boolean wantsJavaScriptFolderStatus, wantsCSSFolderStatus;
    private String websiteName, websiteAuthor, cwdPathWebsiteFolder,
    htmlBase;

    WebsiteGenerator() {
        cwdPathWebsiteFolder = "src/main/java/ex43/website/";
        initScanner();
    };

    private void initScanner() {
        s = new Scanner(System.in);
    };

    public void processWebsiteCreation() {
        askFilesToGenerate();
        generateWebsiteDirectoryContents();
    };

    private void askFilesToGenerate() {
        System.out.print("Site name: ");
        websiteName = s.nextLine();
        System.out.print("Author: ");
        websiteAuthor = s.nextLine();
        htmlBase = String.format("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta name=\"author\" content=\"%s\">\n" + "<title>%s</title>\n" + "</head>\n" + "\n" + "<body>\n" + "\n" + "</body>\n" + "\n" + "</html>", websiteAuthor, websiteName);
        System.out.print("Do you want a folder for JavaScript? ");
        wantsJavaScriptFolderStatus = s.nextLine().charAt(0) == 'y';
        System.out.print("Do you want a folder for CSS? ");
        wantsCSSFolderStatus = s.nextLine().charAt(0) == 'y';
    };

    private void generateWebsiteDirectoryContents() {
        String websiteDirectoryPath = cwdPathWebsiteFolder + websiteName;
        // make website folder
        File websiteDirectory = new File(websiteDirectoryPath);
        if (!websiteDirectory.exists()) {
            websiteDirectory.mkdirs();
            System.out.println("Created ./website/" + websiteName);
        };


        try {
            File websiteIndexHTML = new File(websiteDirectoryPath + "/index.html/");
            websiteIndexHTML.createNewFile();
            System.out.println("Created ./website/" + websiteName + "/index.html");
        } catch (IOException ex) {
            System.out.print(String.format("%s", ex));
        };

        try {
            PrintWriter writer = new PrintWriter(websiteDirectoryPath + "/index.html/", "UTF-8");
            writer.print(htmlBase);
            writer.close();
        } catch (Exception ex) {
            System.out.println(String.format("%s\n%s\n", "Please enter a valid, existing file name.", ex));
        };

        if (wantsJavaScriptFolderStatus) {
            File websiteJSDirectory = new File(websiteDirectoryPath + "/js/");
            if (!websiteJSDirectory.exists()) {
                websiteJSDirectory.mkdirs();
                System.out.println("Created ./website/" + websiteName + "/js/");
            };
        };

        if (wantsCSSFolderStatus) {
            File websiteCSSDirectory = new File(websiteDirectoryPath + "/css/");
            if (!websiteCSSDirectory.exists()) {
                websiteCSSDirectory.mkdirs();
                System.out.println("Created ./website/" + websiteName + "/css/");
            };
        };

    };



}
