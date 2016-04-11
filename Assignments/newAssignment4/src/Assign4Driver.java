/*
    Driver for the Word Ladder Assignment (Assignment 4)
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */
package assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Assign4Driver {

    /*
    METHOD: main
    PURPOSE: driver
    PARAMS: @param command line arguments
    RETURNS: NONE
    */
    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2) {
            System.err.println("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }

        String[] dictionaryStrings = fromDictFile(args[0]);
        Dictionary dictionary = new Dictionary(dictionaryStrings);
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver(dictionary);
        try {

           /*COMMENT THESE LINES TO INPUT FROM THE CODE*/
            /*START*/
//            String[] inputStrings = fromWordsFile(args[1]);
//            for (String pair: inputStrings
//                 ) {
//
//                String[] checkPair = pair.split("[\\s]");
//
//                System.out.println("For the input words " +"\'" + checkPair[0] + "\'" + " and " + "\'" + checkPair[1]+"\'" +" the following word ladder was found:\n");
//                List<String> result = wordLadderSolver.computeLadder(checkPair[0], checkPair[1]);
//                for (String o :
//                        result) {
//                    System.out.println(o + "\n");
//                }
//                System.out.println("*********");
//                boolean correct = wordLadderSolver.validateResult(checkPair[0], checkPair[1], result);
//                if(!correct){
//                    System.out.println("Something went wrong...");
//                }
//                result.clear();
//            }
            /*END*/
            /*UNCOMMENT THESE LINES OUT TO INPUT FROM THE CODE (see Lisa's piazza answer @193) */
            /*START*/
            System.out.println("For the input words " +"\'" + "money" + "\'" + " and " + "\'" + "honey" +"\'" +" the following word ladder was found:\n");
            List<String> result = wordLadderSolver.computeLadder("stpne", "stone");
            for (String o :
                    result) {
                System.out.println(o + "\n");
            }
            System.out.println("*********");
            boolean correct = wordLadderSolver.validateResult("stpne", "stone", result);
            /*END*/

//             boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        } catch (NoSuchLadderException e) {
            e.printStackTrace();
        }
    }

    /*
    METHOD: fromDictFile
    PURPOSE: file reading
    PARAMS: @param the name of the file as a string
    RETURNS: array of strings containing lines from the file
    */
    private static String[] fromDictFile(String filename) {

        List<String> array = new ArrayList<>();

        // open reader
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                if (!s.startsWith("*")) {
                    s = s.substring(0, 5);
                    array.add(s);
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
        String[] newArray = new String[0];
        return array.toArray(newArray);
    }
    /*
    METHOD: fromWordsFile
    PURPOSE: file reading
    PARAMS: @param the name of the input words file as a string
    RETURNS: array of strings pairs separated with comma
    */
    private static String[] fromWordsFile(String filename) {

        List<String> array = new ArrayList<>();

        // open reader
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    array.add(s);
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
        String[] newArray = new String[0];
        return array.toArray(newArray);
    }
}



