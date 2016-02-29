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
    public static String dictRegex = "[//d+*,]";
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public HashMap dictionary = new HashMap();
    ArrayList<String> ladder = new ArrayList<String>();

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
    public WordLadderSolver() {
        //todo don't think the reading works
        InputStream input = getClass().getResourceAsStream("A4-words.txt");
        String[] args = {"A4-words.txt"};
        readFile(args, dictionary);
    }

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {

        if (!areBothWords(startWord, endWord)) {
            //todo error
        }
        if (isOneAway(startWord, endWord)){
            ladder.add(0, startWord);
            ladder.add(1, endWord);
            return ladder;
        }
        AdjacencyMatrix wordGraph = new AdjacencyMatrix(dictionary, startWord, endWord);
        DepthFirstSearch newLadder = new DepthFirstSearch(wordGraph, 0);

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
        return dictionary.containsKey(startWord) && dictionary.containsKey(endWord);
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


    private static void readFile(String[] args, HashMap dictionary) {

        if (args.length != 1) {
            System.err.println("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }
        // open reader
        String filename = args[0];
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                if (!s.startsWith("*")) {
                    s = s.substring(0, 5);
                    dictionary.put(s, 0);
                }
            }
            // close reader
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Error: IO exception. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private boolean makeLadder(String startWord, String endWord, int n) {
        String checkword = startWord;
        if (checkword.equals(endWord)) {
            return true;
        }


        for (int j = n; j < 5; j++) {
            int p = (j + 1);
            for (int i = 0; i < alphabet.length(); i++) {
                checkword = startWord.substring(0, j) + alphabet.charAt(i) + startWord.substring(p, 5);
                if (dictionary.containsKey(checkword) && (!Objects.equals(checkword, startWord))) {
                    return makeLadder(checkword, endWord, n + 1);
                }
            }
        }
        return false;
    }

}
