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

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
    public static String dictRegex = "[//d+*,]";

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
    WordLadderSolver(){
        //todo don't think the reading works
        HashMap dictionary = new HashMap();
        InputStream input = getClass().getResourceAsStream("A4-words.txt");
        String[] args = {"A4-words.txt"};
        readFile(args, dictionary);
    }

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException
    {
        //todo implementation
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder)
    {
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
                if(!s.startsWith("*")){
                    int subst = s.indexOf(dictRegex);
                    if(subst != -1){
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
