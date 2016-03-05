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


    public Dictionary(String[] args) {
        Collections.addAll(dictionary, args);
    }

    public Set<String> getWordSet() {
        return dictionary;
    }

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
}
