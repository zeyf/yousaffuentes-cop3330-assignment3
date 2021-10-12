package ex46;

import java.util.ArrayList;

/*
 * IDEA FOR STRING COLLECTOR:
 *
 * TWO ARRAY LISTS, ONE FOR ACTUAL STRINGS, ONE FOR THE COUNT OF EACH STRING WITH MATCHING INDEXES BETWEEN TWO
 * ONE BOOLEAN VARIABLE TO MARK STATUS OF A STRING COLLECTION COMPLETION
 *
 * METHOD: LINEARSEARCHSTRING
 * AS A NEW STRING IS FOUND VIA LINEAR SEARCH OF ARRAYLIST, ADD IT IN AND SET THE COUNTER NUMBER AT INDEX TO 1
 * IF REENCOUNTERED, INCREMENT AT INDEX
 *
 * METHOD: ADDNEWSTRING ^ ADDS IN NEW STRING TO STRING ARRAY LIST AND SETS SAME INDEX OF FREQ ARRAY LIST TO 1
 *
 * METHOD: SETSTRINGCOLLECTIONSTATUS / GETSTRINGCOLLECTIONSTATUS
 * ALLOWS FOR CHECKING AND SETTING THE STRING COLLECTION STATUS PRE, DURING, AND AFTER STRING COLLECTION
 * AFTER FINALIZING STRING COLLECTION, MARK COLLECTION STATUS AS COMPLETE
 *
 * METHOD: BUILDCOLLECTIONRESULTS
 * BUILDS A STRING TO PRINT THAT INCLUDES WORDS AND THEIR RESPECTIVE COUNTS IN ONE FORMATTED, BUILT STRING
 * JUST NEEDS TO BE PRINTED TO REFLECT PRESENT STATUS.
 *
 * METHOD: GETSTRINGLIST
 * RETURNS THE ARRAY LIST OF UNIQUE STRINGS ENCOUNTERED
 *
 * METHOD: GETSTRINGFREQUENCYLIST
 * RETURNS THE ARRAYLIST OF COUNTER APPEARANCES OF EACH STRING IN STRING LIST RESPECTIVE OF INDEX
 *
 * */

public class StringCollector {

    private static ArrayList<String> foundStrings = new ArrayList<String>();
    private static ArrayList<Integer> foundStringsFrequency = new ArrayList<Integer>();
    private static boolean stringsCollectedCompletionStatus = false;

    public static void addNewString(String newString) {
            foundStrings.add(newString);
            foundStringsFrequency.add(1);
    };

    public static boolean linearSearchForString(String str) {

        if (foundStrings.contains(str)) {
            foundStringsFrequency.set(
                    foundStrings.indexOf(str),
                    foundStringsFrequency.get(foundStrings.indexOf(str)) + 1
            ); // increment
            return true;
        };

        return false;
    };

    public String buildCollectionResults() {
        String baseString = "";
        for (int x = 0; x < foundStrings.size(); x++) {
            baseString += String.format("%s:\t", foundStrings.get(x));
            int currStringFrequency = foundStringsFrequency.get(x);
            for (int y = 0; y < currStringFrequency; y++)
                baseString += "*";
            baseString += "\n";
        };

        return baseString;
    };

    public void setStringsCollectedCompletionStatus(boolean newStatus) {
        stringsCollectedCompletionStatus = newStatus;
    };

    public boolean getStringsCollectedCompletionStatus() {
        return stringsCollectedCompletionStatus;
    };

    public ArrayList<String> getStringList() {
        return foundStrings;
    };

    public ArrayList<Integer> getStringFrequencyList() {
        return foundStringsFrequency;
    };

};
