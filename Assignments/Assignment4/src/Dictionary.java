/*
    Dictionary class for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */


package assignment4;

import java.util.*;


public class Dictionary {
    private final Set<String> dictionary = new TreeSet<>();
    /*
    METHOD:     Dictionary Constructor
    PURPOSE:    constructor for the dictionary
    PARAMS:     @param args the String array containing the names of files set as command line arguments
    RETURNS:    NONE but it does construct a Dictionary
    */
    public Dictionary(String[] args) {
        Collections.addAll(dictionary, args);
    }



    /*
    * METHOD:     Dictionary Constructor
    * PURPOSE:    constructor for the dictionary
    * PARAMS:     @param word the String array containing the names of files set as command line arguments
    * RETURNS:    NONE but it does construct a Dictionary
    */
    public int wordToIndex(String word) {
        int index = -1;
        for (String o : dictionary) {
            index++;
            if (o.equals(word)) {
                return index;
            }
        }
        return -1;
    }

    /*
    METHOD:     index to Word
    PURPOSE:    gets the word at a given index from the dictionary
    PARAMS:     @param index the integer index into the dictionary
    RETURNS:    the string that is at the index location in the dictionary
    */
    public String indexToWord(int index) {
        int counter = -1;
        for (String o : dictionary) {
            counter++;
            if (counter == index) {
                return o;
            }
        }
        return null;
    }

    /*
    METHOD:     getWordSet
    PURPOSE:    getter for the dictionary
    PARAMS:     NONE
    RETURNS:    the Set that is the dictionary
    */
    public Set<String> getWordSet() {
        return dictionary;
    }
}
