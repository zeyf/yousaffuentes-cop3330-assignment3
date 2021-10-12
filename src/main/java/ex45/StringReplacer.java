package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

/*
*
* PSEUDOCODE FOR STIRNG REPLACER:
*
* HAVE THREE ATTRIBUTES: STRING TO FIND, REPLACE STRING, AND BASESTRING
* THE STIRNG TO FIND AND REPLACESTRING ARE TAKEN IN VIA CONSTRUCTOR AT INITIALIZATION
* THE BASESTRING IS INITIALIZED/DECLARED TO AN EMPTY STRING IN CONSTRUCTION TO STORE ALL CLEAN, NEW OUTPUT FOR FILE
*
* METHOD: REPLACETERMINLINE
* TAKES IN A STRING (THE CURRENT LINE FROM INPUT)
* ADDS THIS STRING AND REPLACES WHAT TO FIND SET AT CONSTRUCTOR WITH THE REPLACE STRING USING REGEX AND ADDS NEW LINE TO END
*
* METHOD: GETNEWOUTPUT
* RETURNS THE BUILT BASE STRING FOR PRINTING OUT TO THE NEW OUTPUT FILE WITH REPLACED DATA VIA A WRITER
*
* */

public class StringReplacer {

    private static String stringToFind, replaceString, baseString;

    StringReplacer(String find, String replaceWith) {
        stringToFind = find;
        replaceString = replaceWith;
        baseString = "";
    };

    public static void replaceTermInLine(String line) {
        baseString += line.replaceAll(stringToFind, replaceString) + "\n";
    };

    public String getNewOutput() {
        return baseString;
    };


}
