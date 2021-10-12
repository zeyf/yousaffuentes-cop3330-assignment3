package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ZAIN YOUSAF FUENTES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.*;

/*
* PSEUDO CODE FOR JSON FILE PARSER CLASS
*
* CONSTRUCTOR:
* TAKE IN THE NAME OF THE FILE TO PARSE AS A CONSTRUCTOR PARAMETER FOR NEW INSTANCE OF CLASS
* - CREATE NEW FILE OF FILENAME
* - INITIALIZE A SCANNER TO THE FILE WITH TRY CATCH
* - SETS UP BASE JSON STRING
*
* METHOD: INITSCANNER
* INITIALIZES THE SCANNER WITH TRY CATCH HANDLING IN A SEPARATE FUNCTION THAN CONSTRUCTOR.
* SINCE THIS IS ONLY FOR USE IN CONSTRUCTOR, THIS A PRIVATE METHOD
*
* METHOD: READJSONFILE
* CALLS ON THE SCANNER TO COLLECT THE ENTIRE JSON STRING FILE REPRESENTATION INTO ATTRIBUTE JSONSTRING
*
* METHOD: INITJSONOBJECT
* CREATES AND SETS A NEW JSON OBJECT BASED ON THE STRING COLECTRED FROM THE SCANNING OF READJSONFILE
*
* METHOD: INITJSONPRODUCTSARRAY
* INIT/SETS THE PRODUCT ARRAY OF JSON OBJECTS
*
* METHOD: SEARCHHANDLERPRODUCTSARRAY
* CALLS ON LINEAR SEARCH OF STRING (SEARCHES FOR A NAME OF A PRODUCT IN THE JSONPRODUCT ARRAY SET BY INITJSONPRODUCTSARRAY
* PRINTS OUT NEEDED MESSAGE IF FOUND OR NOT FOUND
*
* METHOD: PRINTPRODUCTNOTFOUND
* PRINTS A NOT FOUND MESSAGE IF PRODUCT IS NOT FOUND IN A LINEAR SEARCH FOR A PRODUCT
*
* METHOD: PRINTPRODUCT
* PRINTS A PRODUCT DATA ASSUMING IT IS FOUND IN A LINEAR SEARCH FOR A STRING IN THE PRODUCTS ARRAY BY NAME
*
* METHOD: GETPRODUCTFOUNDSTATUS
* IS PUBLIC TO KNOW WHEN TO STOP THE LOOP OF ASKING A USER FOR A VALID ITEM NAME (WHEN IT IS FOUND IT IS SET TO TRUE)
* AND THIS CUTS OFF THE LOOP
*
* METHOD: LINEARSEARCHPRODUCTSARRAY
* PERFORMS A LINEAR SEARCH OF THE PRODUCTS JSON OBJECT ARRAY LOOKING FOR A NAME
* IF A NAME WAS FOUND IT RETURNS THE INDEX ELSE IT RETURNS -1 INDICATING PRODUCT NOT FOUND IN LINEAR SCAN
*
* */

public class JsonFileParser {

    private String jsonString;
    private File file;
    private Scanner s;
    private JSONObject jsonObj;
    private JSONArray jsonProductsArray;
    private boolean productFoundStatus;

    JsonFileParser(String fileName) {
        file = new File(fileName);
        jsonString = "";
        productFoundStatus = false;
        initScanner();
        readJSONFile();
        initJSONObject();
        initJSONProductsArray();
    };

    private void initScanner() {
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println(String.format("%s\n%s", ex, "The file name for input was not found!"));
        };
    };

    private void readJSONFile() {
        while (s.hasNextLine())
            jsonString += s.nextLine();
    };

    private void initJSONObject() {
        jsonObj = new JSONObject(jsonString);
    };

    private void initJSONProductsArray() {
        jsonProductsArray = jsonObj.getJSONArray("products"); //always known no need to recurse or check for
    };

    public void searchHandlerOfProductsArray(String productName) {
        int found = linearSearchProductsArray(productName); // -1 means not found
        if (found != -1) { // found
            productFoundStatus = true;
            printProduct(found);
        } else // not found
            printProductNotFound();
    };

    private void printProductNotFound() {
        System.out.println("Sorry, that product was not found in our inventory.");
    };

    private void printProduct(int index) {
        JSONObject product = jsonProductsArray.getJSONObject(index);
        System.out.println(
                String.format(
                        "Name: %s\nPrice: %.2f\nQuantity: %d",
                        product.getString("name"),
                        (double) product.getInt("price"),
                        product.getInt("quantity")
                )
        );
    };

    private int linearSearchProductsArray(String productName) {

        for (int x = 0; x < jsonProductsArray.length(); x++)
            if (jsonProductsArray.getJSONObject(x).getString("name").equals(productName))
                return x;

        return -1;
    };

    public boolean getProductFoundStatus() {
        return productFoundStatus;
    }





}