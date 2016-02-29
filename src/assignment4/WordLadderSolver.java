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
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface {
    // declare class members here.
    public static String dictRegex = "[//d+*,]";
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public HashMap dictionary = new HashMap();

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
        Stack<String> adjWords = new Stack<>();
        String checkword = startWord;
        //index 0
        for (int i = 0; i < alphabet.length(); i++) {
            checkword = alphabet.charAt(i) + startWord.substring(1, 4);
            if (dictionary.containsKey(checkword)) {
                adjWords.push(checkword);
            }
        }
        //index 1
        for (int i = 0; i < alphabet.length(); i++) {
            checkword = startWord.substring(0, 1) + alphabet.charAt(i) + startWord.substring(2, 4);
            if (dictionary.containsKey(checkword)) {
                adjWords.push(checkword);
            }
        }
        //index 2
        for (int i = 0; i < alphabet.length(); i++) {
            checkword = startWord.substring(0, 2) + alphabet.charAt(i) + startWord.substring(3, 4);
            if (dictionary.containsKey(checkword)) {
                adjWords.push(checkword);
            }
        }
        //index 3
        for (int i = 0; i < alphabet.length(); i++) {
            checkword = startWord.substring(0, 3) + alphabet.charAt(i) + startWord.substring(4, 4);
            if (dictionary.containsKey(checkword)) {
                adjWords.push(checkword);
            }
        }
        //index 4
        for (int i = 0; i < alphabet.length(); i++) {
            checkword = startWord.substring(0, 4) + alphabet.charAt(i);
            if (dictionary.containsKey(checkword)) {
                adjWords.push(checkword);
            }
        }
        //todo implementation
        throw new UnsupportedOperationException("Not implemented yet!");
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
                    int subst = s.indexOf(dictRegex);
                    if (subst != -1) {
                        s = s.substring(0, subst);
                    }
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

}
