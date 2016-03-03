package assignment4;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Dictionary {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private Set <String> dictionary = new TreeSet<>();


    public Dictionary(String[] args) {

    }

    public boolean contains(String testWord){
        return dictionary.contains(testWord);
    }

    public boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }

    public Set<String> getWordSet(){
        return dictionary;
    }
}
