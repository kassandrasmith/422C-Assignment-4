/*
    Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */

package assignment4;

import sun.awt.X11.Depth;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface {
    // declare class members here.
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String dictRegex = "[//d+*,]";
    static Dictionary dictionary;

    ArrayList<String> ladder = new ArrayList<String>();

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
    public WordLadderSolver() {
        //todo don't think the reading works
        InputStream input = getClass().getResourceAsStream("A4-words.txt");
        String[] args = {"A4-words.txt"};
        HashMap dictionary = new Dictionary(args).dictionary;
    }

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {

        if (!areBothWords(startWord, endWord)) {
            //todo error
        }
        if (isOneAway(startWord, endWord)) {
            ladder.add(0, startWord);
            ladder.add(1, endWord);
            return ladder;
        }
        //    AdjacencyMatrix wordGraph = new AdjacencyMatrix(dictionary, startWord, endWord);
        //    DepthFirstSearch newLadder = new DepthFirstSearch(wordGraph, 0);

        makeLadder(startWord, endWord, 0);
        makeLadder(startWord, endWord, 1);
        makeLadder(startWord, endWord, 2);
        makeLadder(startWord, endWord, 3);
        makeLadder(startWord, endWord, 4);
        //base case

        //todo implementation
        throw new UnsupportedOperationException("Not implemented yet!");
    }



    private boolean areBothWords(String startWord, String endWord) {
            return dictionary.dictionary.containsKey(startWord) && dictionary.dictionary.containsKey(endWord);
    }

    private boolean isOneAway(String startWord, String endWord) {
        String checkword = startWord;
          for (int i = 0; i < alphabet.length(); i++) {
        for (int j = 0; j < 5; j++) {
            int p = j + 1;
                   checkword = startWord.substring(0, j) + alphabet.charAt(i) + startWord.substring(p, 5);
            if (checkword.equals(endWord)) {
                return true;
            }
        }

            }

            return false;
        }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }


        // add additional methods here


    private boolean makeLadder(String startWord, String endWord, int n) {
        ladder.add(startWord);//starting word should be in our solution
        String checkword = startWord;
        //check if the word is the right word
        if (checkword.equals(endWord)) {
            return true;
        }
        //check if the word is one away
        if (dictionary.isOneAway(startWord, endWord)) {
            ladder.add(endWord);
            return true;
        }
        //todo implementation
        return false;
    }

}
